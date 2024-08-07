package org.csystem.app.rmi.generator.random.runner;

import lombok.extern.slf4j.Slf4j;
import org.csystem.app.rmi.generator.random.client.RandomGeneratorClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

@Component
@Slf4j
public class ClientRunner implements ApplicationRunner {
    private final RandomGeneratorClient m_randomTextGenerator;
    private final ExecutorService m_executorService;

    @Value("${app.n}")
    private int m_n;

    @Value("${app.count}")
    private int m_count;


    private void generateAllTextsCallback()
    {
        m_randomTextGenerator.generateTexts(m_count, m_n);
    }

    public ClientRunner(RandomGeneratorClient randomTextGenerator, ExecutorService executorService)
    {
        m_randomTextGenerator = randomTextGenerator;
        m_executorService = executorService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        m_executorService.submit(this::generateAllTextsCallback);
    }
}
