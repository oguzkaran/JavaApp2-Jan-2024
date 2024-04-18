package com.karandev.util.net;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Disabled("Tested before")
public class TcpUtilSendReceiveStringViaLengthTest {
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
            var text = TcpUtil.receiveStringViaLength(clientSocket);

            Assertions.assertEquals(SEND_TEXT, text);

            text = TcpUtil.receiveStringViaLength(clientSocket);
            Assertions.assertEquals(SEND_TEXT.toUpperCase(), text);
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
            TcpUtil.sendStringViaLength(socket, SEND_TEXT);
            TcpUtil.sendStringViaLength(socket, SEND_TEXT.toUpperCase());
        }
    }

    @AfterEach
    public void tearDown() throws IOException
    {
        m_serverSocket.close();
        m_threadPool.shutdown();
    }
}
