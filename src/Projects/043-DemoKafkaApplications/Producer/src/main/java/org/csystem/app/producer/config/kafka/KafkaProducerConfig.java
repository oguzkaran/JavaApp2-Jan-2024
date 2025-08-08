package org.csystem.app.producer.config.kafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;

@Configuration
public class KafkaProducerConfig {
    @Bean("MyProducerFactory")
    public ProducerFactory<String, String> producerFactory()
    {
        var map = new HashMap<String, Object>();

        map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "161.97.141.113:9092");
        map.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        map.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);


        return new DefaultKafkaProducerFactory<>(map);
    }
}
