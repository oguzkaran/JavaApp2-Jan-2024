package org.csystem.app.imageprocessing.server;

import com.karandev.io.util.console.Console;
import com.karandev.util.net.TcpUtil;
import com.karandev.util.net.exception.NetworkException;
import org.csystem.image.CImage;
import org.csystem.image.CImageFormat;
import org.csystem.net.tcp.server.Server;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GrayscaleImageServer {
    private static final int SOCKET_TIMEOUT = 10000;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyy_HH-mm-ss-n");
    private static final File IMAGE_PATH = new File("grayscale_images");

    private final Server m_server;

    private void saveFile(Socket socket, String path) throws IOException
    {
        try {
            var file = new File(IMAGE_PATH, String.format("%s.png", new File(path).getName()));

            TcpUtil.receiveFile(socket, file);
            file = doGrayscale(file);
            TcpUtil.sendInt(socket, 1);
            TcpUtil.sendFile(socket, file, 1024);
        }
        catch (NetworkException ex) {
            Console.Error.writeLine("Network problem:%s", ex.getMessage());
        }

        TcpUtil.sendInt(socket, 0);
    }

    private File doGrayscale(File file) throws IOException
    {
        var image = new CImage(file);

        var path = file.getAbsolutePath();
        file = new File(path.substring(0, path.lastIndexOf('.') + 1), "-gs.png");

        image.grayScale();
        image.save(file, CImageFormat.PNG);

        return file;
    }

    private void handleClient(Socket socket)
    {
        try (socket) {
            socket.setSoTimeout(SOCKET_TIMEOUT);
            var hostAddress = socket.getInetAddress().getHostAddress();
            var port = socket.getPort();
            Console.writeLine("Client connected to grayscale image server via %s:%d", hostAddress, port);
            var path = String.format("%s_%d_%s", hostAddress, port, FORMATTER.format(LocalDateTime.now()));

            saveFile(socket, path);
        }
        catch (IOException ex) {
            Console.Error.writeLine("GrayScaleImageServer:IO Exception Occurred:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("GrayScaleImageServer:Exception Occurred:%s", ex.getMessage());
        }
    }


    public GrayscaleImageServer(int port, int backlog) throws IOException
    {
        m_server = Server.builder()
                .setPort(port)
                .setBacklog(backlog)
                .setInitRunnable(IMAGE_PATH::mkdirs)
                .setBeforeAcceptRunnable(() -> Console.writeLine("Grayscale image server is waiting for a client on port:%d", port))
                .setClientSocketConsumer(this::handleClient)
                .setServerExceptionConsumer(ex -> Console.Error.writeLine("Exception Occurred:%s", ex.getMessage()))
                .build();


    }

    public void run()
    {
        m_server.run();
    }


}
