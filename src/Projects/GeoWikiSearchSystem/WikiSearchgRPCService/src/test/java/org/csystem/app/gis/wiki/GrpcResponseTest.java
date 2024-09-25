package org.csystem.app.gis.wiki;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-grpc-unittest.properties")
public class GrpcResponseTest {
    @GrpcClient("geo-wiki-search-grpc-service")
    private GeoWikiSearchServiceGrpc.GeoWikiSearchServiceBlockingStub m_stub;

    @Test
    public void givenValues_whenQueryTextAndPageNumberAndDataPerPage_thenReturnData()
    {
        var queryText = "zonguldak";
        var pageSize = 5;
        var pageNumber = 1;
        var dataIndex = 1;
        var expectedSummaryText = "Monfalcone";

        var request = GeoWikiSearchRequest.newBuilder()
                .setQueryText(queryText)
                .setDataPerPage(pageSize)
                .setPageNumber(pageNumber)
                .build();

        var geoWikiSearchInfo = m_stub.findWikiSearchInfo(request);

        int count = 0;

        while (geoWikiSearchInfo.hasNext()) {
            var wi = geoWikiSearchInfo.next();

            if (count++ == dataIndex) {
                assertTrue(wi.getSummary().startsWith(expectedSummaryText));
                return;
            }
        }

        fail();
    }
}
