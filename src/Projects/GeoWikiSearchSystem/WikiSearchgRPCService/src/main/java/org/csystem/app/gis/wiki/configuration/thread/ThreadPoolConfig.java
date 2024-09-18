package org.csystem.app.gis.wiki.configuration.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ThreadPoolConfig {
    @Bean
    public ExecutorService createThreadPool()
    {
        return Executors.newCachedThreadPool();
    }
}
