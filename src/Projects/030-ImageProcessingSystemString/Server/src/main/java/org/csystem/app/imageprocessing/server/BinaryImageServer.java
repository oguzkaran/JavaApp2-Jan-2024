package org.csystem.app.imageprocessing.server;

import com.karandev.io.util.console.Console;
import com.karandev.util.net.TcpUtil;
import com.karandev.util.net.exception.NetworkException;
import org.csystem.image.CImage;
import org.csystem.image.CImageFormat;
import org.csystem.net.tcp.server.ConcurrentServer;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BinaryImageServer {
    private static final int SOCKET_TIMEOUT = 10000;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyy_HH-mm-ss-n");
    private static final File IMAGE_PATH = new File("binary_images");

    private final ConcurrentServer m_server;

    private void saveFile(Socket socket, String path) throws IOException
    {
        try {
            var file = new File(IMAGE_PATH, String.format("%s.png", new File(path).getName()));

            TcpUtil.receiveFile(socket, file);
            var threshold = TcpUtil.receiveInt(socket);
            file = doBinaryImage(file, threshold);

            TcpUtil.sendString(socket, "SUC_BIN");
            TcpUtil.sendFile(socket, file, 1024);
        }
        catch (NetworkException ex) {
            Console.Error.writeLine("Network problem:%s", ex.getMessage());
        }

        TcpUtil.sendString(socket, "ERR_BIN");
        TcpUtil.sendStringViaLength(socket, "Problem occurred while making binary!...");
    }

    private File doBinaryImage(File file, int threshold) throws IOException
    {
        var image = new CImage(file);

        var path = file.getAbsolutePath();
        file = new File(path.substring(0, path.lastIndexOf('.') + 1) +  "-bin.png");

        image.binary(threshold);
        image.save(file, CImageFormat.PNG);

        return file;
    }

    private void handleClient(Socket socket)
    {
        try (socket) {
            socket.setSoTimeout(SOCKET_TIMEOUT);
            var hostAddress = socket.getInetAddress().getHostAddress();
            var port = socket.getPort();
            Console.writeLine("Client connected to Binary image server via %s:%d", hostAddress, port);
            var name = TcpUtil.receiveStringViaLength(socket);

            if (name.length() < 3) {
                TcpUtil.sendString(socket, "ERR_N");
                TcpUtil.sendStringViaLength(socket, "Length of name must be greater or equal than 3(three)");
                return;
            }

            TcpUtil.sendString(socket, "SUC_N");

            var path = String.format("%s_%s_%d_%s", name.substring(0, 3), hostAddress, port, FORMATTER.format(LocalDateTime.now()));

            saveFile(socket, path);
        }
        catch (IOException ex) {
            Console.Error.writeLine("BinaryImageServer:IO Exception Occurred:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("BinaryImageServer:Exception Occurred:%s", ex.getMessage());
        }
    }

    public BinaryImageServer(int port, int backlog) throws IOException
    {
        m_server = ConcurrentServer.builder()
                .setPort(port)
                .setBacklog(backlog)
                .setInitRunnable(IMAGE_PATH::mkdirs)
                .setBeforeAcceptRunnable(() -> Console.writeLine("Binary image server is waiting for a client on port:%d", port))
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
