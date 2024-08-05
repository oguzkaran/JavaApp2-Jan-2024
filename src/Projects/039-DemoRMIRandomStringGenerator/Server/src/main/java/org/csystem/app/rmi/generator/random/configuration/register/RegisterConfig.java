package org.csystem.app.rmi.generator.random.configuration.register;

import org.csystem.app.rmi.generator.random.component.RandomTextGenerator;
import org.csystem.rmi.generator.random.text.IRandomTextGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

@Configuration
public class RegisterConfig {
    private final RandomTextGenerator m_randomTextGenerator;

    @Value("${server.port}")
    private int m_port;

    public RegisterConfig(RandomTextGenerator randomTextGenerator)
    {
        m_randomTextGenerator = randomTextGenerator;
    }

    @Bean
    public Registry createRegistry() throws RemoteException
    {
        return LocateRegistry.createRegistry(m_port);
    }

    @Bean("stub")
    public IRandomTextGenerator createStub() throws RemoteException
    {
        return (IRandomTextGenerator) UnicastRemoteObject.exportObject(m_randomTextGenerator, 0);
    }
}
