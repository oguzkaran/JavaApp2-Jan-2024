package org.csystem.app.generator.random.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Random;
import java.util.random.RandomGenerator;

@Configuration
public class RandomGeneratorConfig {
    @Bean
    @Scope("prototype")
    public RandomGenerator createRandomGenerator()
    {
        return new Random();
    }
}
