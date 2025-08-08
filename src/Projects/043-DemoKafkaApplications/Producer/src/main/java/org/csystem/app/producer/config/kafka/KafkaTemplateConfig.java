package org.csystem.app.producer.config.kafka;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaTemplateConfig {
    private final ProducerFactory<String, String> m_producerFactory;

    public KafkaTemplateConfig(@Qualifier("MyProducerFactory") ProducerFactory<String, String> producerFactory)
    {
        m_producerFactory = producerFactory;
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate()
    {
        return new KafkaTemplate<>(m_producerFactory);
    }
}
