package org.csystem.app.information.server;

import com.karandev.io.util.console.Console;
import org.csystem.net.tcp.server.ConcurrentServer;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;

public class CommunicationServerInfoServer implements Closeable {
    private static final int SOCKET_TIMEOUT = 1000;
    private final ConcurrentServer m_server;

    private void handleClient(Socket socket)
    {
        //...
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
