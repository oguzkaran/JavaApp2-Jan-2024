package org.csystem.app.gis.wiki.mapper;

import org.csystem.app.gis.wiki.GeoWikiSearchInfo;
import org.csystem.app.gis.wiki.data.entity.WikiSearchInfo;
import org.csystem.app.gis.wiki.geonames.dto.GeonamesWikiSearchInfo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class WikiSearchInfoInfoMapper implements IWikiSearchInfoMapper {
    private final ModelMapper m_modelMapper;

    public WikiSearchInfoInfoMapper(ModelMapper modelMapper)
    {
        m_modelMapper = modelMapper;
    }

    @Override
    public GeoWikiSearchInfo toGeoWikiSearchInfo(WikiSearchInfo wikiSearchInfo)
    {
        return m_modelMapper.map(wikiSearchInfo, GeoWikiSearchInfo.class);
    }

    @Override
    public WikiSearchInfo toWikiSearchInfo(GeonamesWikiSearchInfo geonamesWikiSearchInfo)
    {
        return m_modelMapper.map(geonamesWikiSearchInfo, WikiSearchInfo.class);
    }

    @Override
    public GeoWikiSearchInfo toGeoWikiSearchInfo(GeonamesWikiSearchInfo geonamesWikiSearchInfo)
    {
        return m_modelMapper.map(geonamesWikiSearchInfo, GeoWikiSearchInfo.class);
    }
}
