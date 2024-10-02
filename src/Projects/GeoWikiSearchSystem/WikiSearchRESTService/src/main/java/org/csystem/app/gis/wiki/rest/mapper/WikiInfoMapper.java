package org.csystem.app.gis.wiki.rest.mapper;

import org.csystem.app.gis.wiki.GeoWikiSearchInfo;
import org.csystem.app.gis.wiki.rest.dto.GeoWikiSearchDTO;
import org.csystem.app.gis.wiki.rest.dto.GeoWikiSearchInfoDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WikiInfoMapper implements IWikiInfoMapper {
    @Override
    public GeoWikiSearchInfoDTO toGeoWikiSearchInfoDTO(GeoWikiSearchInfo geoWikiSearchInfo)
    {
        return GeoWikiSearchInfoDTO.builder()
                .summary(geoWikiSearchInfo.getSummary())
                .elevation(geoWikiSearchInfo.getElevation())
                .geoNameId(geoWikiSearchInfo.getGeoNameId())
                .feature(geoWikiSearchInfo.getFeature())
                .longitude(geoWikiSearchInfo.getLongitude())
                .countryCode(geoWikiSearchInfo.getCountryCode())
                .rank(geoWikiSearchInfo.getRank())
                .thumbnailImg(geoWikiSearchInfo.getThumbnailImg())
                .lang(geoWikiSearchInfo.getLang())
                .title(geoWikiSearchInfo.getTitle())
                .latitude(geoWikiSearchInfo.getLatitude())
                .wikipediaUrl(geoWikiSearchInfo.getWikipediaUrl())
                .build();
    }

    @Override
    public GeoWikiSearchDTO toGeoWikiSearchDTO(List<GeoWikiSearchInfo> geoWikiSearchInfo)
    {
        var geoWikiSearchDTO = new GeoWikiSearchDTO();

        geoWikiSearchDTO.geoWikiInfo = geoWikiSearchInfo.stream().map(this::toGeoWikiSearchInfoDTO).toList();

        return geoWikiSearchDTO;
    }
}
