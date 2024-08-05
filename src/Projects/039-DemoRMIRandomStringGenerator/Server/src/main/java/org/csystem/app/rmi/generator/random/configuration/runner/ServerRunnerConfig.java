package org.csystem.app.rmi.generator.random.configuration.runner;


import org.csystem.rmi.generator.random.text.IRandomTextGenerator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.rmi.registry.Registry;

@Configuration
public class ServerRunnerConfig {
    private final Registry m_registry;
    private final IRandomTextGenerator m_randomTextGenerator;

    public ServerRunnerConfig(Registry registry,
                              @Qualifier("stub") IRandomTextGenerator randomTextGenerator)
    {
        m_registry = registry;
        m_randomTextGenerator = randomTextGenerator;
    }

    @Bean
    public ApplicationRunner createServerRunner()
    {
        return args -> m_registry.rebind(IRandomTextGenerator.BIND_NAME, m_randomTextGenerator);
    }
}
