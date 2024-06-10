package org.csystem.app.payment.server.configuration;

import org.csystem.app.payment.server.manager.client.PaymentServerInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ServersConfig {
    @Bean
    public Map<Integer, PaymentServerInfo> createServersMap()
    {
        return new HashMap<>();
    }
}
