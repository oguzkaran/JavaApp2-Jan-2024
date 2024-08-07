package org.csystem.app.rmi.generator.random.runner;

import lombok.extern.slf4j.Slf4j;
import org.csystem.rmi.generator.random.text.IRandomTextGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.rmi.RemoteException;
import java.util.concurrent.ExecutorService;
import java.util.stream.IntStream;

@Component
@Slf4j
public class ClientRunner implements ApplicationRunner {
    private final IRandomTextGenerator m_randomTextGenerator;
    private final ExecutorService m_executorService;

    @Value("${app.n}")
    private int m_n;

    @Value("${app.count}")
    private int m_count;

    private void generateTextsCallback()
    {
        try {
            log.info("Text:{}", m_randomTextGenerator.generateRandomTextEN(m_count));
            log.info("Yazı:{}", m_randomTextGenerator.generateRandomTextTR(m_count));
            Thread.sleep(300);
        }
        catch (RemoteException ex) {
            log.error("Remote Exception:{}", ex.getMessage());
        }
        catch (InterruptedException ignore) {

        }
    }

    private void generateAllTextsCallback()
    {
        IntStream.range(0, m_n).forEach(i -> generateTextsCallback());
    }

    public ClientRunner(IRandomTextGenerator randomTextGenerator, ExecutorService executorService)
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
