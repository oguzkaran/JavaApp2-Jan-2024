package org.csystem.app.rmi.generator.random.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

@Configuration
public class RegistryConfig {
    @Bean
    public Registry createRegistry(@Value("${rmiserver.host}") String rmiHost,
                                   @Value("${rmiserver.port}")int rmiPort) throws RemoteException
    {
        return LocateRegistry.getRegistry(rmiHost, rmiPort);
    }
}
