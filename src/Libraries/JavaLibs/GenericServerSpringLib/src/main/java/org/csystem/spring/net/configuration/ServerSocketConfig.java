package org.csystem.spring.net.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.io.IOException;
import java.net.ServerSocket;

@Configuration
public class ServerSocketConfig {
    @Bean("org.csystem.spring.net.concurrentServer.serverSocket")
    @Scope("prototype")
    public ServerSocket createDefaultServerSocket() throws IOException
    {
        return new ServerSocket();
    }

    @Bean("org.csystem.spring.net.serverSocket")
    @Lazy
    public ServerSocket createServerSocket(@Value("${org.csystem.spring.net.port:6767}") int port,
                                           @Value("${org.csystem.spring.net.backlog:512}") int backlog) throws IOException
    {
        return new ServerSocket(port, backlog);
    }
}
