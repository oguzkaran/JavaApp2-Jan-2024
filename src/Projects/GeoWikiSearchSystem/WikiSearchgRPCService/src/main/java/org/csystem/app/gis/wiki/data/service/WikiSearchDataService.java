package org.csystem.app.gis.wiki.data.service;

import lombok.extern.slf4j.Slf4j;
import org.csystem.app.gis.wiki.data.repository.IWikiSearchInfoRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WikiSearchDataService {
    private final IWikiSearchInfoRepository m_wikiSearchInfoRepository;

    public WikiSearchDataService(IWikiSearchInfoRepository wikiSearchInfoRepository)
    {
        m_wikiSearchInfoRepository = wikiSearchInfoRepository;
    }

    //...
}
