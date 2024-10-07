package org.csystem.app.gis.wiki.data.mapper;

import org.csystem.app.gis.wiki.data.entity.WikiSearchInfo;
import org.csystem.app.gis.wiki.geonames.dto.GeonamesWikiSearchInfo;
import org.modelmapper.ModelMapper;

public class WikiSearchInfoInfoMapper implements IWikiSearchInfoMapper {
    private final ModelMapper m_modelMapper;

    public WikiSearchInfoInfoMapper(ModelMapper modelMapper)
    {
        m_modelMapper = modelMapper;
    }

    @Override
    public WikiSearchInfo toWikiSearchInfo(GeonamesWikiSearchInfo geonamesWikiSearchInfo)
    {
        return m_modelMapper.map(geonamesWikiSearchInfo, WikiSearchInfo.class);
    }

}
