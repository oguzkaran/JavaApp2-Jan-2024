package org.csystem.app.information.server;

import com.karandev.io.util.console.Console;
import com.karandev.util.net.TcpUtil;
import org.csystem.net.tcp.server.ConcurrentServer;

import java.io.IOException;
import java.net.Socket;
import java.util.Random;

import static org.csystem.communication.library.common.CommunicationMessage.ERROR;
import static org.csystem.communication.library.common.CommunicationMessage.SUCCESS;

public class SendInformationServer {
    private static final int SOCKET_TIMEOUT = 1000;
    private final ConcurrentServer m_server;
    private final int m_port;
    private final String m_name;

    private boolean meetingExists(String id)
    {
        //check if meeting exists by looking database
        var random = new Random();

        return random.nextBoolean();
    }

    private void handleClient(Socket socket)
    {
        try (socket) {
            socket.setSoTimeout(SOCKET_TIMEOUT);
            var idOpt = TcpUtil.receiveLineOptional(socket);

            if (idOpt.isEmpty())
                return;

            var id = idOpt.get();

            if (meetingExists(id)) {
                Console.writeLine("Name:%s", m_name);
                TcpUtil.sendLine(socket, SUCCESS);
                TcpUtil.sendLine(socket, String.valueOf(m_port + 1));
            }
            else
                TcpUtil.sendLine(socket, ERROR);
        }
        catch (IOException ex) {
            Console.Error.writeLine("Send Information Server:IO Exception Occurred:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Send Information Server:Exception Occurred:%s", ex.getMessage());
        }
    }

    public SendInformationServer(int port, int backlog, String name) throws IOException
    {
        m_name = name;
        m_server = ConcurrentServer.builder()
                .setPort(m_port = port)
                .setBacklog(backlog)
                .setServerExceptionConsumer(ex -> Console.writeLine(ex.getMessage()))
                .setBeforeAcceptRunnable(() -> Console.writeLine("Send Information server '%s' is waiting for a client on port:%d", m_name, port))
                .setClientSocketConsumer(this::handleClient)
                .build();
    }

    public void run()
    {
        m_server.start();
    }
}
