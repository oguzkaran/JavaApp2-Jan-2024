package org.csystem.app.payment.server.manager.manage;

import com.karandev.io.util.console.Console;
import com.karandev.util.net.TcpUtil;
import com.karandev.util.net.exception.NetworkException;
import org.csystem.app.payment.server.manager.client.PaymentServerInfo;
import org.csystem.app.payment.server.manager.client.factory.PaymentServerFactory;
import org.csystem.net.tcp.server.ConcurrentServer;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;

import static org.csystem.app.payment.server.manager.global.ServerUtil.SERVERS;
import static org.csystem.app.payment.server.manager.global.ServerUtil.SYNC_OBJECT;

public class PaymentServerInfoServer implements Closeable {
    private static final int SOCKET_TIMEOUT = 4000;
    private final ConcurrentServer m_server;

    private void addServerCallback(PaymentServerInfo paymentServerInfo, int id, Socket socket)
    {
        SERVERS.put(id, paymentServerInfo);
        Console.writeLine("Number of server:%d", SERVERS.size());
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

            Console.writeLine("Payment Server Info -> id:%d, host:%s, info:%s", id, host, infoStr);

            synchronized (SYNC_OBJECT) {
                if (!SERVERS.containsKey(id)) {
                    var paymentFactory = new PaymentServerFactory();
                    paymentFactory.create(id, host, infoStr)
                            .ifPresentOrElse(p -> addServerCallback(p, id, socket), () -> addServerFailCallback(socket));
                }
                else
                    TcpUtil.sendByte(socket, (byte)0);
            }
        }
        catch (NetworkException ex) {
            Console.Error.writeLine("Payment Server Info Server:Network Exception Occurred:%s", ex.getMessage());
        }
        catch (IOException ex) {
            Console.Error.writeLine("Payment Server Info Server:IO Exception Occurred:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Payment Server Info Server:Exception Occurred: Exception: %s, Message:%s",
                    ex.getClass().getSimpleName(), ex.getMessage());
            TcpUtil.sendByte(socket, (byte)0);
        }
    }

    public PaymentServerInfoServer(int port, int backlog) throws IOException
    {
        m_server = ConcurrentServer.builder()
                .setPort(port)
                .setBacklog(backlog)
                .setBeforeAcceptRunnable(() -> Console.writeLine("CreditCard Payment server info server is waiting for a client on port:%d", port))
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
