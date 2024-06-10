package org.csystem.spring.net.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration("org.csystem.spring.net.executorService.config")
public class ExecutorServiceConfig {
    @Bean("org.csystem.spring.net.executorService")
    @Scope("prototype")
    public ExecutorService createExecutorService()
    {
        return Executors.newCachedThreadPool();
    }    
}
