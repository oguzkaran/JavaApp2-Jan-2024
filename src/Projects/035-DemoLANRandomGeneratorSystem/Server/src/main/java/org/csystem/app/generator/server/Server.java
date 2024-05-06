package org.csystem.app.generator.server;

import com.karandev.io.util.console.Console;
import com.karandev.util.net.TcpUtil;
import com.karandev.util.net.exception.NetworkException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private final int m_port;
    private final ExecutorService m_threadPool;

    private void handleClient(Socket socket)
    {
        try (socket) {
            Console.writeLine("Text:%s", TcpUtil.receiveLine(socket).strip());
        }
        catch (NetworkException ex) {
            Console.Error.writeLine("Network problem occurred:" + ex.getMessage());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Problem occurred:" + ex.getMessage());
        }
    }

    public Server(int port)
    {
        m_port = port;
        m_threadPool = Executors.newCachedThreadPool();
    }

    public void run()
    {
        try (var serverSocket = new ServerSocket(m_port)) {
            while (true) {
                var clientSocket = serverSocket.accept();

                m_threadPool.execute(() -> handleClient(clientSocket));
            }
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Error occurred:%s", ex.getMessage());
        }
    }
}
