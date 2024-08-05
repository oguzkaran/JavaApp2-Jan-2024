package org.csystem.app.rmi.generator.random.configuration.server;


import org.csystem.rmi.generator.random.text.IRandomTextGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

@Configuration
public class RandomTextGeneratorConfig {
    private final Registry m_registry;

    public RandomTextGeneratorConfig(Registry registry)
    {
        m_registry = registry;
    }

    @Bean
    public IRandomTextGenerator createProxy() throws RemoteException, NotBoundException
    {
        return (IRandomTextGenerator)m_registry.lookup(IRandomTextGenerator.BIND_NAME);
    }
}
