package org.csystem.app.payment.server;

import com.karandev.io.util.console.Console;
import com.karandev.util.net.TCP;
import com.karandev.util.net.exception.NetworkException;
import lombok.extern.slf4j.Slf4j;
import org.csystem.app.payment.server.manager.client.CardOperationInfo;
import org.csystem.app.payment.server.manager.client.ClientInfo;
import org.csystem.app.payment.server.manager.client.PaymentServerInfo;
import org.csystem.spring.net.tcp.server.ConcurrentServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@ComponentScan("org.csystem")
@Slf4j
public class Server implements Closeable {
    private static final int SOCKET_TIMEOUT = 4000;
    private final ConcurrentServer m_server;
    private final List<CardOperationInfo> m_serverInfo;
    private final Map<Integer, PaymentServerInfo> m_servers;
    private final Object m_syncObject;

    @Value("${app.server.port}")
    private int m_port;

    @Value("${app.server.backlog}")
    private int m_backlog;

    private Optional<PaymentServerInfo> findPaymentInfo(int type)
    {
        return m_servers.containsKey(type) ? Optional.of(m_servers.get(type)) : Optional.empty();
    }
    
    private void sendInformationOptionalCallback(PaymentServerInfo pi, CardOperationInfo coi, TCP tcp)
    {
        tcp.sendByte((byte)1);
        coi.getClientInfoConsumer().accept(new ClientInfo(tcp, pi));
    }

    private void handleClient(Socket socket)
    {
        try (socket) {
            var tcp = new TCP(socket, SOCKET_TIMEOUT);
            var cardType = tcp.receiveByte();
            var index = m_serverInfo.indexOf(new CardOperationInfo(cardType));

            if (index != -1) {
                var coi = m_serverInfo.get(index);
                Optional<PaymentServerInfo> opt;

                synchronized (m_syncObject) {
                    opt = findPaymentInfo(coi.getType());
                }
                opt.ifPresentOrElse(p -> sendInformationOptionalCallback(p, coi, tcp), () -> tcp.sendByte((byte)-1));
            }
            else
                tcp.sendByte((byte)0);
        }
        catch (NetworkException ex) {
            log.error("Payment Manager Server:Network Exception Occurred:{}", ex.getMessage());
        }
        catch (IOException ex) {
            log.error("Payment Manager Server:IO Exception Occurred:{}", ex.getMessage());
        }
        catch (Throwable ex) {
            log.error("Payment Manager Server:Exception Occurred:{}", ex.getMessage());
        }
    }

    public Server(ConcurrentServer server,
                  List<CardOperationInfo> serverInfo,
                  Map<Integer, PaymentServerInfo> servers,
                  @Qualifier("sync") Object syncObject)
    {
        m_server = server;
        m_serverInfo = serverInfo;
        m_servers = servers;
        m_syncObject = syncObject;

        m_server.setPort(m_port)
            .setBacklog(m_backlog)
            .setBeforeAcceptRunnable(() -> log.info("Payment Manager Server info server is waiting for a client on port:{}", m_port))
            .setClientSocketConsumer(this::handleClient);
    }

    public void run()
    {
        m_server.start();
    }

    public void close()
    {
        m_server.stop();
    }
}
