package org.csystem.app.gis.wiki.geonames;

import org.csystem.app.gis.wiki.geonames.service.GeonamesWikiSearchService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootApplication
@SpringBootTest
public class GeonamesWikiSearchServiceTest {
    @Autowired
    private GeonamesWikiSearchService m_geonamesWikiSearchService;

    @Test
    public void givenQueryText_whenPlace_thenReturnsExpected()
    {
        var queryText = "zonguldak";
        var maxRows = 10;
        var expectedTitle = "Zonguldak Province";

        var wikiInfo = m_geonamesWikiSearchService.findWikiSearchInfo(queryText, maxRows);

        assertNotNull(wikiInfo);
        assertEquals(expectedTitle, wikiInfo.get(0).title);
    }

    //...
}
