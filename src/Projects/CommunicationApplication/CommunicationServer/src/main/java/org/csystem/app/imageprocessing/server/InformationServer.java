package org.csystem.app.imageprocessing.server;

import com.karandev.io.util.console.Console;
import com.karandev.util.net.TcpUtil;
import org.csystem.net.tcp.server.ConcurrentServer;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.time.format.DateTimeFormatter;

public class InformationServer implements Closeable {
    private static final int SOCKET_TIMEOUT = 1000;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss-n");
    private final ConcurrentServer m_server;

    private void handleClient(Socket socket)
    {
        try (socket) {
            socket.setSoTimeout(SOCKET_TIMEOUT);
            var id = TcpUtil.receiveLine(socket);
            var name = TcpUtil.receiveLine(socket);

            

            var host = "xxxx";
            var port = 12345;

            TcpUtil.sendLine(socket, String.format("%s:%d", host, port));
        }
        catch (IOException ex) {
            Console.Error.writeLine("GrayScaleImageServer:IO Exception Occurred:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("GrayScaleImageServer:Exception Occurred:%s", ex.getMessage());
        }
    }

    public InformationServer(int port, int backlog) throws IOException
    {
        m_server = ConcurrentServer.builder()
                .setPort(port)
                .setBacklog(backlog)
                //.setInitRunnable(() -> {})
                .setBeforeAcceptRunnable(() -> Console.writeLine("Information server is waiting for a client on port:%d", port))
                .setClientSocketConsumer(this::handleClient)
                //.setServerExceptionConsumer(ex -> Console.Error.writeLine("Exception Occurred:%s", ex.getMessage()))
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
