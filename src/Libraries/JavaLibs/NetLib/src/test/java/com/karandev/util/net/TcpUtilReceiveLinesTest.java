package com.karandev.util.net;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Disabled("Run the debug test")
public class TcpUtilReceiveLinesTest {
    private static final String HOST = "localhost";
    private static final int PORT = 50500;
    private static final int SOCKET_TIMEOUT = 1000;
    private static final String SEND_TEXT = "Deniz Karan";
    private ServerSocket m_serverSocket;
    private ExecutorService m_threadPool;

    private void serverCallback()
    {
        try {
            m_serverSocket = new ServerSocket(PORT);
            var clientSocket = m_serverSocket.accept();
            clientSocket.setSoTimeout(SOCKET_TIMEOUT);
            var lines = TcpUtil.receiveLines(clientSocket);

            Assertions.assertEquals(SEND_TEXT, lines[0]);
            Assertions.assertEquals(SEND_TEXT.toUpperCase(), lines[1]);
            Assertions.assertEquals(SEND_TEXT, lines[2]);
        }
        catch (Throwable ex) {
            ex.printStackTrace();
        }
    }

    @BeforeEach
    public void setUp()
    {
        m_threadPool = Executors.newSingleThreadExecutor();
        m_threadPool.execute(this::serverCallback);
    }

    @Test
    public void test() throws IOException
    {
        try (var socket = new Socket(HOST, PORT)) {
            TcpUtil.sendLine(socket, SEND_TEXT);
            TcpUtil.sendLine(socket, SEND_TEXT.toUpperCase());
            TcpUtil.sendLine(socket, SEND_TEXT);
        }
    }

    @AfterEach
    public void tearDown() throws IOException
    {
        m_serverSocket.close();
        m_threadPool.shutdown();
    }
}
