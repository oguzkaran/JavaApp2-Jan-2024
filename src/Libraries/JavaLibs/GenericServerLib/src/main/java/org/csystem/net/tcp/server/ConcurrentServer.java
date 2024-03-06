package org.csystem.net.tcp.server;

import org.csystem.net.function.IConsumer;
import org.csystem.net.function.IRunnable;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentServer {
    private final ExecutorService m_threadPool;
    private ServerSocket m_serverSocket;
    private int m_port = 6767;
    private int m_backlog = 512;
    private IRunnable m_initRunnable;
    private IRunnable m_beforeAcceptRunnable;
    private IConsumer<Socket> m_clientSocketConsumer = s -> {};
    private IConsumer<Throwable> m_serverExceptionConsumer;

    public static class Builder {
        private final ConcurrentServer m_concurrentServer;

        private Builder()
        {
            m_concurrentServer = new ConcurrentServer();
        }

        public Builder setPort(int port)
        {
            m_concurrentServer.m_port = port;

            return this;
        }

        public Builder setBacklog(int backlog)
        {
            m_concurrentServer.m_backlog = backlog;

            return this;
        }

        public Builder setInitRunnable(IRunnable runnable)
        {
            m_concurrentServer.m_initRunnable = runnable;

            return this;
        }

        public Builder setBeforeAcceptRunnable(IRunnable runnable)
        {
            m_concurrentServer.m_beforeAcceptRunnable = runnable;

            return this;
        }

        public Builder setClientSocketConsumer(IConsumer<Socket> clientSocketConsumer)
        {
            m_concurrentServer.m_clientSocketConsumer = clientSocketConsumer;

            return this;
        }

        public Builder setServerExceptionConsumer(IConsumer<Throwable> serverExceptionConsumer)
        {
            m_concurrentServer.m_serverExceptionConsumer = serverExceptionConsumer;

            return this;
        }

        public ConcurrentServer build() throws IOException
        {
            m_concurrentServer.m_serverSocket = new ServerSocket(m_concurrentServer.m_port, m_concurrentServer.m_backlog);

            return m_concurrentServer;
        }
    }

    private void handleClient(Socket socket)
    {
        try {
            m_clientSocketConsumer.accept(socket);
        }
        catch (Throwable ignore) {
            //...
        }
    }

    private void serverThreadCallback()
    {
        try {
            if (m_initRunnable != null)
                m_initRunnable.run();

            while (true) {
                if (m_beforeAcceptRunnable != null)
                    m_beforeAcceptRunnable.run();

                var socket = m_serverSocket.accept();

                m_threadPool.execute(() -> handleClient(socket));
            }
        }
        catch (Throwable ex) {
            try {
                m_serverExceptionConsumer.accept(ex);
            }
            catch (Exception ignore) {
                //...
            }
        }
        finally {
            m_threadPool.shutdown();
        }
    }

    private ConcurrentServer()
    {
        m_threadPool = Executors.newCachedThreadPool();
    }

    public static Builder builder()
    {
        return new Builder();
    }

    public void run()
    {
        m_threadPool.execute(this::serverThreadCallback);
    }
}
