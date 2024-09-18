package org.csystem.app.gis.wiki.data.service;

import lombok.extern.slf4j.Slf4j;
import org.csystem.app.gis.wiki.GeoWikiSearchInfo;
import org.csystem.app.gis.wiki.data.dal.WikiSearchDataHelper;
import org.csystem.app.gis.wiki.data.entity.WikiSearchInfo;
import org.csystem.app.gis.wiki.geonames.dto.GeonamesWikiSearchInfo;
import org.csystem.app.gis.wiki.geonames.service.GeonamesWikiSearchService;
import org.csystem.app.gis.wiki.mapper.IWikiSearchInfoMapper;
import org.csystem.util.data.service.exception.DataServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;

@Service
@Slf4j
public class WikiSearchDataService {
    private final GeonamesWikiSearchService m_geonamesWikiSearchService;
    private final WikiSearchDataHelper m_wikiSearchDataHelper;
    private final IWikiSearchInfoMapper m_wikiSearchMapper;
    private final ExecutorService m_threadPool;

    private void saveDatabaseThreadCallback(String queryText, List<GeonamesWikiSearchInfo> geonamesWikiSearchInfo)
    {
        var wikiSearchInfo = geonamesWikiSearchInfo.stream().map(m_wikiSearchMapper::toWikiSearchInfo).toList();

        m_wikiSearchDataHelper.saveWikiSearchInfo(queryText, wikiSearchInfo);
    }

    private List<GeoWikiSearchInfo> inDatabase(List<WikiSearchInfo> wikiSearchInfo)
    {
        return wikiSearchInfo.stream().map(m_wikiSearchMapper::toGeoWikiSearchInfo).toList();
    }

    private List<GeoWikiSearchInfo> notInDatabase(String queryText)
    {
        var wikiSearchInfo = m_geonamesWikiSearchService.findWikiSearchInfo(queryText, 1000);

        //...
        m_threadPool.execute(() -> saveDatabaseThreadCallback(queryText, wikiSearchInfo));

        return wikiSearchInfo.stream().map(m_wikiSearchMapper::toGeoWikiSearchInfo).toList();
    }

    public WikiSearchDataService(GeonamesWikiSearchService geonamesWikiSearchService, WikiSearchDataHelper wikiSearchDataHelper, IWikiSearchInfoMapper wikiSearchMapper, ExecutorService threadPool)
    {
        m_geonamesWikiSearchService = geonamesWikiSearchService;
        m_wikiSearchDataHelper = wikiSearchDataHelper;
        m_wikiSearchMapper = wikiSearchMapper;
        m_threadPool = threadPool;
    }

    public List<GeoWikiSearchInfo> findWikiSearchByQueryText(String queryText, int dataPerPage, int pageNumber)
    {
        try {
            var wikiSearchInfo = m_wikiSearchDataHelper.findWikiSearchInfoByQueryText(queryText, dataPerPage, pageNumber);

            return wikiSearchInfo.isEmpty() ? notInDatabase(queryText) : inDatabase(wikiSearchInfo);
        }
        catch (Throwable ex) {
            log.error("Exception occurred in WikiSearchDataService.findWikiSearchByQueryText:{}", ex.getMessage());
            throw new DataServiceException("WikiSearchDataService.findWikiSearchByQueryText", ex);
        }
    }

}
