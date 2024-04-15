package org.csystem.app.information.server;

import com.karandev.io.util.console.Console;
import com.karandev.util.net.TcpUtil;
import com.karandev.util.net.exception.NetworkException;
import org.csystem.app.information.server.communication.client.CommunicationServerInfo;
import org.csystem.app.information.server.communication.global.CommunicationServerUtil;
import org.csystem.net.tcp.server.ConcurrentServer;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;

import static org.csystem.communication.library.common.CommunicationMessage.ERROR_INVALID_PORT;
import static org.csystem.communication.library.common.CommunicationMessage.SUCCESS_PORT;

public class CommunicationServerInfoServer implements Closeable {
    private static final int SOCKET_TIMEOUT = 4000;

    private final ConcurrentServer m_server;

    private void handleClient(Socket socket)
    {
        try (socket) {
            socket.setSoTimeout(SOCKET_TIMEOUT);
            var host = socket.getInetAddress().getHostAddress();
            var name = TcpUtil.receiveStringViaLength(socket);
            var port = TcpUtil.receiveInt(socket);

            Console.writeLine("Communication Server:%s, %s:%d", name, host, port);

            if (port < 1024) {
                TcpUtil.sendStringViaLength(socket, ERROR_INVALID_PORT);
                return;
            }

            TcpUtil.sendStringViaLength(socket, SUCCESS_PORT);

            synchronized (CommunicationServerUtil.SYNC_SERVERS_OBJECT) {
                CommunicationServerUtil.SERVERS.add(new CommunicationServerInfo(name, host, port));
                CommunicationServerUtil.SERVERS.forEach(Console::writeLine);
            }
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

    public CommunicationServerInfoServer(int port, int backlog) throws IOException
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
