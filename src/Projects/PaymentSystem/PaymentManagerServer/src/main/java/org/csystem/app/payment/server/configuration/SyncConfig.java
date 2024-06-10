package org.csystem.app.payment.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SyncConfig {
    @Bean("sync")
    public Object createSyncObject()
    {
        return new Object();
    }
}
