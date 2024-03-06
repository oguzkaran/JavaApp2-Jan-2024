/*----------------------------------------------------------
	FILE			: ConcurrentServer.java
	AUTHOR			: JavaApp2-Jab-2024 Group
	LAST UPDATE		: 6th March 2024

	Class that represents a general server

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
------------------------------------------------------------*/
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
            //m_threadPool.shutdown();
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

    public void start()
    {
        try {
            m_serverSocket = new ServerSocket(m_port, m_backlog);
            m_threadPool.execute(this::serverThreadCallback);
        }
        catch (IOException ignore) {
            //...
        }
    }

    public void stop()
    {
        try {
            m_serverSocket.close();
        }
        catch (IOException ignore) {
            //...
        }
    }
}
