package org.csystem.app.gis.wiki.data.mapper;

import org.csystem.app.gis.wiki.data.entity.WikiSearchInfo;
import org.csystem.app.gis.wiki.geonames.dto.GeonamesWikiSearchInfo;

public interface IWikiSearchInfoMapper {
    WikiSearchInfo toWikiSearchInfo(GeonamesWikiSearchInfo geoWikiSearchInfo);
}
