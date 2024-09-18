package org.csystem.app.gis.wiki.data.repository;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.csystem.app.gis.wiki.GeoWikiSearchServiceGrpc;
import org.csystem.app.gis.wiki.data.dal.WikiSearchDataHelper;
import org.csystem.app.gis.wiki.geonames.service.GeonamesWikiSearchService;
import org.csystem.app.gis.wiki.mapper.IWikiSearchInfoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootApplication
@SpringBootTest
@EntityScan(basePackages = "org.csystem.app.gis.wiki.data.entity")
@ComponentScan(basePackages = "org.csystem")
@EnableJpaRepositories
@TestPropertySource(locations = "classpath:application-unittest.properties")
public class WikiSearchInfoTest {
    @Autowired
    private WikiSearchDataHelper m_wikiSearchDataHelper;

    @Autowired
    private IWikiSearchInfoRepository m_wikiSearchInfoRepository;

    @Autowired
    private GeonamesWikiSearchService m_geonamesWikiSearchService;

    @Autowired
    private IWikiSearchInfoMapper m_wikiSearchInfoMapper;

    @BeforeEach
    public void setUp()
    {
        var queryText = "zonguldak";
        var geonamesWikiSearch = m_geonamesWikiSearchService.findWikiSearchInfo(queryText, 1000);
        var wikiSearchInfo = geonamesWikiSearch.stream().map(m_wikiSearchInfoMapper::toWikiSearchInfo).toList();

        m_wikiSearchDataHelper.saveWikiSearchInfo(queryText, wikiSearchInfo);
    }

    @Test
    public void test()
    {
        var queryText = "zonguldak";
        var pageSize = 5;
        var pageNumber = 1; //second page
        var dataIndex = 1;
        var expectedSummaryText = "Monfalcone";

        var pageable = PageRequest.of(pageNumber, pageSize);
        var result = m_wikiSearchInfoRepository.findByQueryText(queryText, pageable);

        assertFalse(result.isEmpty());
        assertTrue(result.getContent().get(dataIndex).summary.startsWith(expectedSummaryText));
    }
}
