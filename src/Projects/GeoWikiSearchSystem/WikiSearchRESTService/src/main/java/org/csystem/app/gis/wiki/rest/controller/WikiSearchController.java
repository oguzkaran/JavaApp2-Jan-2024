package org.csystem.app.gis.wiki.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.csystem.app.gis.wiki.rest.dto.GeoWikiSearchDTO;
import org.csystem.app.gis.wiki.rest.service.WikiSearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/geo/wiki")
@Slf4j
public class WikiSearchController {
    private final WikiSearchService m_wikiSearchService;

    public WikiSearchController(WikiSearchService wikiSearchService)
    {
        m_wikiSearchService = wikiSearchService;
    }

    @GetMapping
    public GeoWikiSearchDTO findWikiSearch(String q, @RequestParam(name = "npage") int dataPerPage,
                                                           @RequestParam(name = "pnum")int pageNumber)
    {
        return  m_wikiSearchService.findGeoWikiInfo(q, dataPerPage, pageNumber);
    }
}
