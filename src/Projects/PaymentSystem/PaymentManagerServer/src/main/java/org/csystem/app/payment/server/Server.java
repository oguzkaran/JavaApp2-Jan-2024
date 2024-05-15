package org.csystem.app.payment.server;

import com.karandev.io.util.console.Console;
import com.karandev.util.net.TCP;
import com.karandev.util.net.exception.NetworkException;
import org.csystem.app.payment.server.manager.client.PaymentServerInfo;
import static org.csystem.app.payment.server.manager.global.ServerUtil.*;
import org.csystem.net.tcp.server.ConcurrentServer;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

public class Server implements Closeable {
    private static final int SOCKET_TIMEOUT = 4000;
    private final ConcurrentServer m_server;
    private final List<CardOperationInfo> SERVER_INFO;

    {
        SERVER_INFO = new ArrayList<>();
        SERVER_INFO.add(new CardOperationInfo(1, this::sendInformationCallback));
        SERVER_INFO.add(new CardOperationInfo(2, this::sendInformationCallback));
    }

    private static class ClientInfo {
        TCP tcp;
        PaymentServerInfo paymentServerInfo;

        public ClientInfo(TCP tcp, PaymentServerInfo paymentServerInfo)
        {
            this.tcp = tcp;
            this.paymentServerInfo = paymentServerInfo;
        }
    }

    private static class CardOperationInfo {
        int type;
        Consumer<ClientInfo> clientInfoConsumer;

        CardOperationInfo(int type)
        {
            this(type, null);
        }

        CardOperationInfo(int type, Consumer<ClientInfo> clientInfoConsumer)
        {
            this.type = type;
            this.clientInfoConsumer = clientInfoConsumer;
        }

        @Override
        public int hashCode()
        {
            return Objects.hashCode(type);
        }

        @Override
        public boolean equals(Object other)
        {
            return other instanceof CardOperationInfo ci && ci.type == type;
        }

        @Override
        public String toString()
        {
            return "%s".formatted(type);
        }
    }

    private void sendInformationCallback(ClientInfo clientInfo)
    {
        var tcp = clientInfo.tcp;

        tcp.sendLine(clientInfo.paymentServerInfo.serverInfo());
    }

    private Optional<PaymentServerInfo> findPaymentInfo(int type)
    {
        return SERVERS.containsKey(type) ? Optional.of(SERVERS.get(type)) : Optional.empty();
    }

    private void handleClient(Socket socket)
    {
        try (socket) {
            var tcp = new TCP(socket, SOCKET_TIMEOUT);
            var cardType = tcp.receiveByte();
            var index = SERVER_INFO.indexOf(new CardOperationInfo(cardType));

            if (index != -1) {
                tcp.sendByte((byte)1);
                var coi = SERVER_INFO.get(index);
                Optional<PaymentServerInfo> opt;

                synchronized (SYNC_OBJECT) {
                    opt = findPaymentInfo(coi.type);
                }
                opt.ifPresentOrElse(p -> coi.clientInfoConsumer.accept(new ClientInfo(tcp, p)),
                        () -> tcp.sendByte((byte)-1));
            }
            else
                tcp.sendByte((byte)0);
        }
        catch (NetworkException ex) {
            Console.Error.writeLine("Payment Manager Server:Network Exception Occurred:%s", ex.getMessage());
        }
        catch (IOException ex) {
            Console.Error.writeLine("Payment Manager Server:IO Exception Occurred:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Payment Manager Server:Exception Occurred:%s", ex.getMessage());
        }
    }

    public Server(int port, int backlog) throws IOException
    {
        m_server = ConcurrentServer.builder()
                .setPort(port)
                .setBacklog(backlog)
                .setBeforeAcceptRunnable(() -> Console.writeLine("Payment Manager Server info server is waiting for a client on port:%d", port))
                .setClientSocketConsumer(this::handleClient)
                .build();
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
