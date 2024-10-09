package org.csystem.app.gis.wiki.scheduler.service;

import lombok.extern.slf4j.Slf4j;
import org.csystem.app.gis.wiki.data.dal.WikiSearchDataHelper;
import org.csystem.app.gis.wiki.data.entity.WikiSearch;
import org.csystem.app.gis.wiki.geonames.service.GeonamesWikiSearchService;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WikiSearchUpdateService {
    private final GeonamesWikiSearchService m_geonamesWikiSearchService;
    private final WikiSearchDataHelper m_wikiSearchDataHelper;

    private void wikiSearchesForEachCallback(WikiSearch wikiSearch)
    {
        var geoWikiSearches = m_geonamesWikiSearchService.findWikiSearchInfo(wikiSearch.queryText, 1000);

        log.info("Geonames WikiSearches:{}", geoWikiSearches);
        //
    }

    public WikiSearchUpdateService(GeonamesWikiSearchService geonamesWikiSearchService, WikiSearchDataHelper wikiSearchDataHelper)
    {
        m_geonamesWikiSearchService = geonamesWikiSearchService;
        m_wikiSearchDataHelper = wikiSearchDataHelper;
    }

    public void update()
    {
        var wikiSearches = m_wikiSearchDataHelper.findAllWikiSearches();

        wikiSearches.forEach(this::wikiSearchesForEachCallback);
    }
}
