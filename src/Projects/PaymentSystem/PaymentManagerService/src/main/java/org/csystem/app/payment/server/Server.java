package org.csystem.app.payment.server;

import com.karandev.io.util.console.Console;
import com.karandev.util.net.TCP;
import com.karandev.util.net.exception.NetworkException;
import org.csystem.app.payment.server.communication.client.PaymentServerInfo;
import org.csystem.net.tcp.server.ConcurrentServer;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Server implements Closeable {
    private static final int SOCKET_TIMEOUT = 4000;
    private final ConcurrentServer m_server;
    private final List<CardOperationInfo> SERVER_INFO;

    {
        SERVER_INFO = new ArrayList<>();
        SERVER_INFO.add(new CardOperationInfo(1, this::creditCardCallback));
        SERVER_INFO.add(new CardOperationInfo(2, this::ticketCardCallback));
    }

    private static class CardOperationInfo {
        int type;
        Runnable runnable;

        CardOperationInfo(int type)
        {
            this.type = type;
        }

        CardOperationInfo(int type, Runnable runnable)
        {
            this.type = type;
            this.runnable = runnable;
        }

        @Override
        public boolean equals(Object other)
        {
            return other instanceof CardOperationInfo ci && ci.type == type;
        }
        //..
    }

    private void creditCardCallback()
    {
        //Send the information of the credit card server information to client
    }

    private void ticketCardCallback()
    {
        //Send the information of the ticket card service information to client
    }

    private void handleClient(Socket socket)
    {
        try (socket) {
            socket.setSoTimeout(SOCKET_TIMEOUT);
            var tcp = new TCP(socket, SOCKET_TIMEOUT);
            var cardType = tcp.receiveByte();
            var index = SERVER_INFO.indexOf(new CardOperationInfo(cardType));

            if (index != -1) {
                tcp.sendByte((byte)1);
                SERVER_INFO.get(index).runnable.run();
            }
            else
                tcp.sendByte((byte)0);
        }
        catch (NetworkException ex) {
            Console.Error.writeLine("CommunicationInfoServer Server:Network Exception Occurred:%s", ex.getMessage());
        }
        catch (IOException ex) {
            Console.Error.writeLine("CommunicationInfoServer ServerServer:IO Exception Occurred:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("CommunicationInfoServer Server Server:Exception Occurred:%s", ex.getMessage());
        }
    }

    public Server(int port, int backlog) throws IOException
    {
        m_server = ConcurrentServer.builder()
                .setPort(port)
                .setBacklog(backlog)
                .setBeforeAcceptRunnable(() -> Console.writeLine("Communication server info server is waiting for a client on port:%d", port))
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
