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
        return GeoWikiSearchInfo.newBuilder()
                .setSummary(wikiSearchInfo.summary != null ? wikiSearchInfo.summary : "")
                .setElevation(wikiSearchInfo.elevation)
                .setGeoNameId(wikiSearchInfo.geoNameId)
                .setFeature(wikiSearchInfo.feature != null ? wikiSearchInfo.feature :"")
                .setLongitude(wikiSearchInfo.longitude)
                .setCountryCode(wikiSearchInfo.countryCode != null ? wikiSearchInfo.countryCode : "")
                .setRank(wikiSearchInfo.rank)
                .setThumbnailImg(wikiSearchInfo.thumbnailImg != null ? wikiSearchInfo.thumbnailImg : "")
                .setLang(wikiSearchInfo.lang != null ? wikiSearchInfo.lang : "")
                .setTitle(wikiSearchInfo.title != null ? wikiSearchInfo.title : "")
                .setLatitude(wikiSearchInfo.latitude)
                .setWikipediaUrl(wikiSearchInfo.wikipediaUrl != null ? wikiSearchInfo.wikipediaUrl : "")
                .build();

    }

    @Override
    public WikiSearchInfo toWikiSearchInfo(GeonamesWikiSearchInfo geonamesWikiSearchInfo)
    {
        return m_modelMapper.map(geonamesWikiSearchInfo, WikiSearchInfo.class);
    }

    @Override
    public GeoWikiSearchInfo toGeoWikiSearchInfo(GeonamesWikiSearchInfo geonamesgeonamesWikiSearchInfo)
    {
        return GeoWikiSearchInfo.newBuilder()
                .setSummary(geonamesgeonamesWikiSearchInfo.summary != null ? geonamesgeonamesWikiSearchInfo.summary : "")
                .setElevation(geonamesgeonamesWikiSearchInfo.elevation)
                .setGeoNameId(geonamesgeonamesWikiSearchInfo.geoNameId)
                .setFeature(geonamesgeonamesWikiSearchInfo.feature != null ? geonamesgeonamesWikiSearchInfo.feature :"")
                .setLongitude(geonamesgeonamesWikiSearchInfo.longitude)
                .setCountryCode(geonamesgeonamesWikiSearchInfo.countryCode != null ? geonamesgeonamesWikiSearchInfo.countryCode : "")
                .setRank(geonamesgeonamesWikiSearchInfo.rank)
                .setThumbnailImg(geonamesgeonamesWikiSearchInfo.thumbnailImg != null ? geonamesgeonamesWikiSearchInfo.thumbnailImg : "")
                .setLang(geonamesgeonamesWikiSearchInfo.lang != null ? geonamesgeonamesWikiSearchInfo.lang : "")
                .setTitle(geonamesgeonamesWikiSearchInfo.title != null ? geonamesgeonamesWikiSearchInfo.title : "")
                .setLatitude(geonamesgeonamesWikiSearchInfo.latitude)
                .setWikipediaUrl(geonamesgeonamesWikiSearchInfo.wikipediaUrl != null ? geonamesgeonamesWikiSearchInfo.wikipediaUrl : "")
                .build();
    }
}
