package org.csystem.app.gis.wiki.rest.mapper;

import org.csystem.app.gis.wiki.GeoWikiSearchInfo;
import org.csystem.app.gis.wiki.rest.dto.GeoWikiSearchDTO;
import org.csystem.app.gis.wiki.rest.dto.GeoWikiSearchInfoDTO;

import java.util.List;

public interface IWikiInfoMapper {
    GeoWikiSearchInfoDTO toGeoWikiSearchInfoDTO(GeoWikiSearchInfo geoWikiSearchInfo);
    GeoWikiSearchDTO toGeoWikiSearchDTO(List<GeoWikiSearchInfo> geoWikiSearchInfo);
}
