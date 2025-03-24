package org.csystem.app.producer.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.random.RandomGenerator;

@Component
@Slf4j
public class ProducerRunner implements CommandLineRunner {
    private final KafkaTemplate<String, String> m_kafkaTemplate;
    private final ScheduledExecutorService m_scheduledExecutorService;
    private final RandomGenerator m_randomGenerator;

    @Value("${app.topic}")
    private String m_topic;

    private void kafkaProducerCallback()
    {
        var value = m_randomGenerator.nextInt(0, 100);
        log.info("Value: {}", value);
        m_kafkaTemplate.send(m_topic, "Value:%d".formatted(value));
    }

    public ProducerRunner(KafkaTemplate<String, String> kafkaTemplate,
                          ScheduledExecutorService scheduledExecutorService,
                          RandomGenerator randomGenerator)
    {
        m_kafkaTemplate = kafkaTemplate;
        m_scheduledExecutorService = scheduledExecutorService;
        m_randomGenerator = randomGenerator;
    }

    @Override
    public void run(String... args) throws Exception
    {
        m_scheduledExecutorService.scheduleAtFixedRate(this::kafkaProducerCallback, 5, 1, TimeUnit.MILLISECONDS);
    }
}
