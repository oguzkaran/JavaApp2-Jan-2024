/*----------------------------------------------------------
	FILE			: ConcurrentServer.java
	AUTHOR			: JavaApp2-Jab-2024 Group
	LAST UPDATE		: 3rd June 2024

	Class that represents a general server

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
------------------------------------------------------------*/
package org.csystem.spring.net.tcp.server;

import org.csystem.spring.net.constant.Constant;
import org.csystem.spring.net.function.IConsumer;
import org.csystem.spring.net.function.IRunnable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

@Component(Constant.CONCURRENT_SERVER_BEAN_NAME)
@Scope("prototype")
public class ConcurrentServer {
    private final ExecutorService m_threadPool;
    private final ServerSocket m_serverSocket;

    @Value("6767")
    private int m_port;
    @Value("512")
    private int m_backlog;
    private IRunnable m_initRunnable;
    private IRunnable m_beforeAcceptRunnable;
    private IConsumer<Socket> m_clientSocketConsumer = s -> {};
    private IConsumer<Throwable> m_serverExceptionConsumer;

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
            
            m_serverSocket.bind(new InetSocketAddress(m_port), m_backlog);

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

    }

    public ConcurrentServer(@Qualifier("org.csystem.spring.net.executorService") ExecutorService threadPool,
                            @Qualifier("org.csystem.spring.net.concurrentServer.serverSocket") ServerSocket serverSocket)
    {
        m_threadPool = threadPool;
        m_serverSocket = serverSocket;
    }

    public ConcurrentServer setPort(int port)
    {
        m_port = port;

        return this;
    }

    public ConcurrentServer setBacklog(int backlog)
    {
        m_backlog = backlog;

        return this;
    }

    public ConcurrentServer setInitRunnable(IRunnable runnable)
    {
        m_initRunnable = runnable;

        return this;
    }

    public ConcurrentServer setBeforeAcceptRunnable(IRunnable runnable)
    {
        m_beforeAcceptRunnable = runnable;

        return this;
    }

    public ConcurrentServer setClientSocketConsumer(IConsumer<Socket> clientSocketConsumer)
    {
        m_clientSocketConsumer = clientSocketConsumer;

        return this;
    }

    public ConcurrentServer setServerExceptionConsumer(IConsumer<Throwable> serverExceptionConsumer)
    {
        m_serverExceptionConsumer = serverExceptionConsumer;

        return this;
    }

    public void start()
    {
        m_threadPool.execute(this::serverThreadCallback);
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
