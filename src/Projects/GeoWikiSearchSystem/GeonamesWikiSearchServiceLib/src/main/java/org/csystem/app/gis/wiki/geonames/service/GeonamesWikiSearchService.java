package org.csystem.app.gis.wiki.geonames.service;

import lombok.extern.slf4j.Slf4j;
import org.csystem.app.gis.wiki.geonames.dto.GeonamesWikiSearch;
import org.csystem.app.gis.wiki.geonames.dto.GeonamesWikiSearchInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class GeonamesWikiSearchService {
    private static final String URL_FORMAT = "http://api.geonames.org/wikipediaSearchJSON?q=%s&maxRows=%d&username=csystem";

    private final RestTemplate m_restTemplate;

    public GeonamesWikiSearchService(RestTemplate restTemplate)
    {
        m_restTemplate = restTemplate;
    }

    public List<GeonamesWikiSearchInfo> findWikiSearchInfo(String queryText, int maxRow)
    {
        var wikiSearch = m_restTemplate.getForObject(URL_FORMAT.formatted(queryText, maxRow), GeonamesWikiSearch.class);

        return wikiSearch != null ? wikiSearch.wikiInfo : new ArrayList<>();
    }
}
