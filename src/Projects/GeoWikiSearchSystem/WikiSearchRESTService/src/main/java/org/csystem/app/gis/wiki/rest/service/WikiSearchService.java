package org.csystem.app.gis.wiki.rest.service;

import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.csystem.app.gis.wiki.GeoWikiSearchInfo;
import org.csystem.app.gis.wiki.GeoWikiSearchRequest;
import org.csystem.app.gis.wiki.GeoWikiSearchServiceGrpc;
import org.csystem.app.gis.wiki.rest.dto.GeoWikiSearchDTO;
import org.csystem.app.gis.wiki.rest.exception.BlankStringException;
import org.csystem.app.gis.wiki.rest.exception.NegativeIntException;
import org.csystem.app.gis.wiki.rest.mapper.IWikiInfoMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class WikiSearchService {
    @GrpcClient("geo-wiki-search-grpc-service")
    private GeoWikiSearchServiceGrpc.GeoWikiSearchServiceBlockingStub m_stub;

    private final IWikiInfoMapper m_wikiInfoMapper;

    public WikiSearchService(IWikiInfoMapper wikiInfoMapper)
    {
        m_wikiInfoMapper = wikiInfoMapper;
    }

    public GeoWikiSearchDTO findGeoWikiInfo(String q, int dataPerPage, int pageNumber)
    {
        if (q.isBlank())
            throw new BlankStringException("Text can not be blank");

        if (dataPerPage < 0 || pageNumber < 0)
            throw new NegativeIntException("Invalid values:", dataPerPage, pageNumber);

        var request = GeoWikiSearchRequest.newBuilder()
                .setQueryText(q)
                .setDataPerPage(dataPerPage)
                .setPageNumber(pageNumber)
                .build();

        var iter = m_stub.findWikiSearchInfo(request);
        var list = new ArrayList<GeoWikiSearchInfo>();

        while (iter.hasNext())
            list.add(iter.next());

        return m_wikiInfoMapper.toGeoWikiSearchDTO(list);
    }
}
