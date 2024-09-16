package org.csystem.app.gis.wiki.data.mapper;

import org.csystem.app.gis.wiki.GeoWikiSearchInfo;
import org.csystem.app.gis.wiki.data.entity.WikiSearchInfo;
import org.csystem.app.gis.wiki.geonames.dto.GeonamesWikiSearchInfo;
import org.springframework.stereotype.Component;

@Component
public class WikiSearchInfoMapper implements IWikiSearchInfoMapper {
    @Override
    public WikiSearchInfo toWikiSearchInfo(GeonamesWikiSearchInfo geonamesWikiSearchInfo)
    {
        var wi = new WikiSearchInfo();

        wi.summary = geonamesWikiSearchInfo.getSummary();
        wi.countryCode = geonamesWikiSearchInfo.getCountryCode();
        wi.elevation = geonamesWikiSearchInfo.getElevation();
        wi.feature = geonamesWikiSearchInfo.getFeature();
        wi.geoNameId = geonamesWikiSearchInfo.getGeoNameId();
        wi.lang = geonamesWikiSearchInfo.getLang();
        wi.latitude = geonamesWikiSearchInfo.getLatitude();
        wi.longitude = geonamesWikiSearchInfo.getLongitude();
        wi.rank = geonamesWikiSearchInfo.getRank();
        wi.thumbnailImg = geonamesWikiSearchInfo.getThumbnailImg();
        wi.title = geonamesWikiSearchInfo.getTitle();
        wi.wikipediaUrl = geonamesWikiSearchInfo.getWikipediaUrl();

        return wi;
    }
}
