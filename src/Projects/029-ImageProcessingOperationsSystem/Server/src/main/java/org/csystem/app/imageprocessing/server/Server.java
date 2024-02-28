package org.csystem.app.imageprocessing.server;

import com.karandev.io.util.console.Console;
import org.csystem.io.image.CImage;
import org.csystem.io.image.CImageFormat;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int SOCKET_TIMEOUT = 10000;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyy_HH-mm-ss-n");
    private static final File IMAGE_PATH = new File("images");
    private final ExecutorService m_threadPool;
    private final ServerSocket m_serverSocket;
    private final int m_port;
    private final int m_backlog;

    private void saveFile(String path, Socket socket) throws IOException
    {
        byte result = 0;
        var file = new File(IMAGE_PATH, path);

        try (var fos = new FileOutputStream(file)) {
            var is = socket.getInputStream();
            var dos = new DataInputStream(is);
            var length = dos.readLong();

            for (var i = 0; i < length; ++i)
                fos.write(is.read());

            result = 1;
            doGrayScale(file);
        }
        catch (Throwable ignore) {
            file.delete();
        }

        socket.getOutputStream().write(result);

    }

    private void doGrayScale(File file) throws IOException
    {
        var image = new CImage(file);

        image.grayScale();
        image.save(new File(file.getAbsolutePath() + "-gs"), CImageFormat.PNG);
    }

    private void handleClient(Socket socket)
    {
        try (socket) {
            socket.setSoTimeout(SOCKET_TIMEOUT);
            var hostAddress = socket.getInetAddress().getHostAddress();
            var port = socket.getPort();
            Console.writeLine("Client connected via %s:%d", hostAddress, port);
            var path = String.format("%s_%d_%s", hostAddress, port, FORMATTER.format(LocalDateTime.now()));

            saveFile(path, socket);
        }
        catch (IOException ex) {
            Console.Error.writeLine("IO Exception Occurred:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Exception Occurred:%s", ex.getMessage());
        }
    }

    private void serverThreadCallback()
    {
        try {
            while (true) {
                Console.writeLine("Image Processing server is waiting for a client on port:%d", m_port);
                var socket = m_serverSocket.accept();

                m_threadPool.execute(() -> handleClient(socket));
            }
        }
        catch (IOException ex) {
            Console.Error.writeLine("IO Exception Occurred:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Exception Occurred:%s", ex.getMessage());
        }
        finally {
            m_threadPool.shutdown();
        }
    }

    public Server(int port, int backlog) throws IOException
    {
        m_threadPool = Executors.newCachedThreadPool();
        m_port = port;
        m_backlog = backlog;
        m_serverSocket = new ServerSocket(m_port, m_backlog);
        IMAGE_PATH.mkdirs();
    }

    public void run()
    {
        m_threadPool.execute(this::serverThreadCallback);
    }


}
