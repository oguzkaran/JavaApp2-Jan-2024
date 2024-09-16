package org.csystem.app.gis.wiki.data.dal;

import lombok.extern.slf4j.Slf4j;
import org.csystem.app.gis.wiki.data.entity.WikiSearch;
import org.csystem.app.gis.wiki.data.entity.WikiSearchInfo;
import org.csystem.app.gis.wiki.data.repository.IWikiSearchInfoRepository;
import org.csystem.app.gis.wiki.data.repository.IWikiSearchRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Slf4j
public class WikiSearchDataHelper {
    private final IWikiSearchRepository m_wikiSearchRepository;
    private final IWikiSearchInfoRepository m_wikiSearchInfoRepository;

    public WikiSearchDataHelper(IWikiSearchRepository wikiSearchRepository, IWikiSearchInfoRepository wikiSearchInfoRepository)
    {
        m_wikiSearchRepository = wikiSearchRepository;
        m_wikiSearchInfoRepository = wikiSearchInfoRepository;
    }

    @Transactional
    public void saveWikiSearchInfo(String queryText, List<WikiSearchInfo> wikiSearchInfo)
    {
        var wikiSearch = new WikiSearch();

        wikiSearch.queryText = queryText;
        var ws = m_wikiSearchRepository.save(wikiSearch);

        wikiSearchInfo.stream().peek(wi -> wi.wikiSearch = ws)
                .forEach(m_wikiSearchInfoRepository::save);
    }

    public Page<WikiSearchInfo> findWikiSearchInfoByQueryText(String queryText, Pageable pageable)
    {
        //Exception managing
        return m_wikiSearchInfoRepository.findByQueryText(queryText, pageable);
    }
}
