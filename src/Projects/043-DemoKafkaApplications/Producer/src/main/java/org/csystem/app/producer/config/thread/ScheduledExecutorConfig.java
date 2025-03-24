package org.csystem.app.producer.config.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Configuration
public class ScheduledExecutorConfig {
    @Bean
    public ScheduledExecutorService executorService()
    {
        return Executors.newScheduledThreadPool(1);
    }
}
