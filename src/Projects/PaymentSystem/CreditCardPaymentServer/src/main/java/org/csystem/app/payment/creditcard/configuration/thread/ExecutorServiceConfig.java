package org.csystem.app.payment.creditcard.configuration.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ExecutorServiceConfig {
    @Bean
    @Primary
    public ExecutorService createThreadPool()
    {
        return Executors.newCachedThreadPool();
    }
}
