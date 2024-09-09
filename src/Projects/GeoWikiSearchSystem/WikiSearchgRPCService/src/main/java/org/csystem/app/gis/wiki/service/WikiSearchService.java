package org.csystem.app.gis.wiki.service;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.csystem.app.gis.wiki.GeoWikiSearchInfo;
import org.csystem.app.gis.wiki.GeoWikiSearchRequest;
import org.csystem.app.gis.wiki.GeoWikiSearchServiceGrpc;
import org.csystem.app.gis.wiki.data.service.WikiSearchDataService;
import org.csystem.app.gis.wiki.geonames.service.GeonamesWikiSearchService;
import org.springframework.context.annotation.Scope;

@GrpcService
@Scope("prototype")
@Slf4j
public class WikiSearchService extends GeoWikiSearchServiceGrpc.GeoWikiSearchServiceImplBase {
    private final GeonamesWikiSearchService m_geonamesWikiSearchService;
    private final WikiSearchDataService m_wikiSearchDataService;

    public WikiSearchService(GeonamesWikiSearchService geonamesWikiSearchService, WikiSearchDataService wikiSearchDataService)
    {
        m_geonamesWikiSearchService = geonamesWikiSearchService;
        m_wikiSearchDataService = wikiSearchDataService;
    }

    @Override
    public void findWikiSearchInfo(GeoWikiSearchRequest request, StreamObserver<GeoWikiSearchInfo> responseObserver)
    {
        var queryText = request.getQueryText();
        var dataPerPage = request.getDataPerPage();
        var pageNumber = request.getPageNumber();

        log.info("Query text:{}, Data per page:{}, Page number:{}", queryText, dataPerPage, pageNumber);

        // Check data in database, if found add to response else get from Geonames, save db then add to response.
        // Save db and add to response will be asynchronous operations.
        //...
    }
}
