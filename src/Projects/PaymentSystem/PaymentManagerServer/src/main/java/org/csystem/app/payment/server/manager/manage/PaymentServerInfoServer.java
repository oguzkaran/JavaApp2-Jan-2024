package org.csystem.app.payment.server.manager.manage;

import com.karandev.io.util.console.Console;
import com.karandev.util.net.TcpUtil;
import com.karandev.util.net.exception.NetworkException;
import lombok.extern.slf4j.Slf4j;
import org.csystem.app.payment.server.manager.client.PaymentServerInfo;
import org.csystem.app.payment.server.manager.client.factory.PaymentServerFactory;
import org.csystem.spring.net.tcp.server.ConcurrentServer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

@Component
@Slf4j
public class PaymentServerInfoServer implements Closeable {
    private static final int SOCKET_TIMEOUT = 4000;
    private final ConcurrentServer m_server;
    private final Map<Integer, PaymentServerInfo> m_servers;
    private final Object m_syncObject;

    @Value("${app.server.info.port}")
    private int m_port;

    @Value("${app.server.info.backlog}")
    private int m_backlog;

    private void addServerCallback(PaymentServerInfo paymentServerInfo, int id, Socket socket)
    {
        m_servers.put(id, paymentServerInfo);
        log.info("Number of servers:{}", m_servers.size());
        TcpUtil.sendByte(socket, (byte)1);
    }

    private void addServerFailCallback(Socket socket)
    {
        //...
        TcpUtil.sendByte(socket, (byte)0);
    }

    private void handleClient(Socket socket)
    {
        try (socket) {
            socket.setSoTimeout(SOCKET_TIMEOUT);
            var host = socket.getInetAddress().getHostAddress();
            var id = TcpUtil.receiveInt(socket);
            var infoStr = TcpUtil.receiveStringViaLength(socket);

            log.info("Payment Server Info -> id:{}, host:{}, info:{}", id, host, infoStr);

            synchronized (m_syncObject) {
                if (!m_servers.containsKey(id)) {
                    var paymentFactory = new PaymentServerFactory();

                    paymentFactory.create(id, host, infoStr)
                            .ifPresentOrElse(p -> addServerCallback(p, id, socket), () -> addServerFailCallback(socket));
                }
                else
                    TcpUtil.sendByte(socket, (byte)0);
            }
        }
        catch (NetworkException ex) {
            log.error("Payment Server Info Server:Network Exception Occurred:{}", ex.getMessage());
        }
        catch (IOException ex) {
            log.error("Payment Server Info Server:IO Exception Occurred:{}", ex.getMessage());
        }
        catch (Throwable ex) {
            log.error("Payment Server Info Server:Exception Occurred: Exception: {}, Message:{}",
                    ex.getClass().getSimpleName(), ex.getMessage());
            TcpUtil.sendByte(socket, (byte)0);
        }
    }

    public PaymentServerInfoServer(ConcurrentServer server, Map<Integer, PaymentServerInfo> servers,
                                   @Qualifier("sync") Object syncObject)
    {
        m_server = server;
        m_servers = servers;
        m_syncObject = syncObject;
    }

    public void run()
    {
        m_server.setPort(m_port)
                .setBacklog(m_backlog)
                .setBeforeAcceptRunnable(() -> log.info("Payment server info server is waiting for a client on port:{}", m_port))
                .setClientSocketConsumer(this::handleClient);
        m_server.start();
    }

    public void close()
    {
        m_server.stop();
    }


}
