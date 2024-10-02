package org.csystem.app.gis.wiki.configuration.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ModelMapperConfig {
    @Bean
    @Scope("prototype")
    public ModelMapper createModelMapper()
    {
        return new ModelMapper();
    }
}
