package org.csystem.app.gis.wiki.mapper;

import org.csystem.app.gis.wiki.GeoWikiSearchInfo;
import org.csystem.app.gis.wiki.data.entity.WikiSearchInfo;
import org.csystem.app.gis.wiki.geonames.dto.GeonamesWikiSearchInfo;

public interface IWikiSearchInfoMapper {
    GeoWikiSearchInfo toGeoWikiSearchInfo(WikiSearchInfo wikiSearchInfo);
    WikiSearchInfo toWikiSearchInfo(GeonamesWikiSearchInfo geonamesWikiSearchInfo);
    GeoWikiSearchInfo toGeoWikiSearchInfo(GeonamesWikiSearchInfo geonamesWikiSearchInfo);
}
