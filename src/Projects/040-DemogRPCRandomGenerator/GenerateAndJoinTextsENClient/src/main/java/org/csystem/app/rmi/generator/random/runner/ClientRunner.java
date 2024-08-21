package org.csystem.app.rmi.generator.random.runner;

import lombok.extern.slf4j.Slf4j;
import org.csystem.app.rmi.generator.random.client.RandomGeneratorENClient;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

@Component
@Slf4j
public class ClientRunner implements ApplicationRunner {
    private final RandomGeneratorENClient m_randomTextGeneratorEN;
    private final ExecutorService m_executorService;

    private void generateTextCallback()
    {
        m_randomTextGeneratorEN.generateText();
    }

    public ClientRunner(RandomGeneratorENClient randomTextGeneratorEN, ExecutorService executorService)
    {
        m_randomTextGeneratorEN = randomTextGeneratorEN;
        m_executorService = executorService;
    }

    @Override
    public void run(ApplicationArguments args)
    {
        m_executorService.submit(this::generateTextCallback);
    }
}
