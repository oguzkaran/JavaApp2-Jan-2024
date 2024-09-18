package org.csystem.app.gis.wiki.configuration.mapper;

import org.csystem.app.gis.wiki.data.entity.WikiSearchInfo;
import org.csystem.app.gis.wiki.geonames.dto.GeonamesWikiSearchInfo;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
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
