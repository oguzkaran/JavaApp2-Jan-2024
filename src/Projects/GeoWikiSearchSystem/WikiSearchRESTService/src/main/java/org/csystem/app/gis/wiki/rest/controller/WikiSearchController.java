package org.csystem.app.gis.wiki.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.csystem.app.gis.wiki.rest.dto.GeoWikiSearchDTO;
import org.csystem.app.gis.wiki.rest.service.WikiSearchService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<GeoWikiSearchDTO> findWikiSearch(String q, @RequestParam(name = "npage") int dataPerPage,
                                                           @RequestParam(name = "pnum")int pageNumber)
    {
        try {
            var geoWikiInfo = m_wikiSearchService.findGeoWikiInfo(q, dataPerPage, pageNumber);

            log.info("GeoWikiSearchInfo:{}", geoWikiInfo.toString());

            return ResponseEntity.ok(geoWikiInfo);
        }
        catch (Throwable ex) {
            log.error("WikiSearchController.findWikiSearch:{}", ex.getMessage());

            return ResponseEntity.internalServerError().body(null);
        }
    }
}
