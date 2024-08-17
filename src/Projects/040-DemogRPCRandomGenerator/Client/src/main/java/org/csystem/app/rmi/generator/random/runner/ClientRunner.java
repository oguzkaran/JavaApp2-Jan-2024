package org.csystem.app.rmi.generator.random.runner;

import lombok.extern.slf4j.Slf4j;
import org.csystem.app.rmi.generator.random.client.RandomGeneratorENClient;
import org.csystem.app.rmi.generator.random.client.RandomGeneratorTRClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

@Component
@Slf4j
public class ClientRunner implements ApplicationRunner {
    private final RandomGeneratorENClient m_randomTextGeneratorEN;
    private final RandomGeneratorTRClient m_randomTextGeneratorTR;
    private final ExecutorService m_executorService;

    @Value("${app.n}")
    private int m_n;

    @Value("${app.count}")
    private int m_count;

    private void generateAllTextsENCallback()
    {
        m_randomTextGeneratorEN.generateTexts(m_count, m_n);
    }

    private void generateAllTextsTRCallback()
    {
        m_randomTextGeneratorTR.generateTexts(m_n);
    }

    public ClientRunner(RandomGeneratorENClient randomTextGeneratorEN, RandomGeneratorTRClient randomTextGeneratorTR,
                        ExecutorService executorService)
    {
        m_randomTextGeneratorEN = randomTextGeneratorEN;
        m_randomTextGeneratorTR = randomTextGeneratorTR;
        m_executorService = executorService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        //m_executorService.submit(this::generateAllTextsTRCallback);
        m_executorService.submit(this::generateAllTextsENCallback);
    }
}
