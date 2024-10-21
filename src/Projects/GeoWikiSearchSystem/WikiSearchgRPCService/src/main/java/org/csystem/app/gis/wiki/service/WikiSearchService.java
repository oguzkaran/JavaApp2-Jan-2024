package org.csystem.app.gis.wiki.service;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.csystem.app.gis.wiki.GeoWikiSearchInfo;
import org.csystem.app.gis.wiki.GeoWikiSearchRequest;
import org.csystem.app.gis.wiki.GeoWikiSearchServiceGrpc;
import org.csystem.app.gis.wiki.data.service.WikiSearchDataService;
import org.csystem.util.data.service.exception.DataServiceException;
import org.springframework.context.annotation.Scope;

import static org.csystem.util.grpc.error.GrpcErrorUtil.*;

@GrpcService
@Scope("prototype")
@Slf4j
public class WikiSearchService extends GeoWikiSearchServiceGrpc.GeoWikiSearchServiceImplBase {
    private final WikiSearchDataService m_wikiSearchDataService;

    private void doFind(String queryText, int dataPerPage, int pageNumber, StreamObserver<GeoWikiSearchInfo> responseObserver)
    {
        var wikiSearch = m_wikiSearchDataService.findWikiSearchByQueryText(queryText, dataPerPage, pageNumber);

        wikiSearch.stream().peek(wi -> log.info("WikiSearchInfo:{}", wi.getSummary()))
                .forEach(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    public WikiSearchService(WikiSearchDataService wikiSearchDataService)
    {
        m_wikiSearchDataService = wikiSearchDataService;
    }

    @Override
    public void findWikiSearchInfo(GeoWikiSearchRequest request, StreamObserver<GeoWikiSearchInfo> responseObserver)
    {
        var queryText = request.getQueryText();
        var dataPerPage = request.getDataPerPage();
        var pageNumber = request.getPageNumber();

        if (dataPerPage <= 0 || pageNumber <= 0) {
            outOfRangeError(responseObserver, "Data per page value and page number must be positive");
            return;
        }

        log.info("Query text:{}, Data per page:{}, Page number:{}", queryText, dataPerPage, pageNumber);

        try {
            doFind(queryText, dataPerPage, pageNumber, responseObserver);
        }
        catch (DataServiceException ex) {
            unavailableError(responseObserver, ex.getCause().getMessage());
        }
        catch (Throwable ex) {
            internalError(responseObserver, ex.getMessage());
        }
    }
}
