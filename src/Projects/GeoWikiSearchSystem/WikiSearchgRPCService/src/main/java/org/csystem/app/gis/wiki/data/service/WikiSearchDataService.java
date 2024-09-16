package org.csystem.app.gis.wiki.data.service;

import lombok.extern.slf4j.Slf4j;
import org.csystem.app.gis.wiki.data.dal.WikiSearchDataHelper;
import org.csystem.app.gis.wiki.data.repository.IWikiSearchInfoRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WikiSearchDataService {
    private final WikiSearchDataHelper m_wikiSearchDataHelper;

    public WikiSearchDataService(WikiSearchDataHelper wikiSearchDataHelper)
    {
        m_wikiSearchDataHelper = wikiSearchDataHelper;
    }


    //...
}
