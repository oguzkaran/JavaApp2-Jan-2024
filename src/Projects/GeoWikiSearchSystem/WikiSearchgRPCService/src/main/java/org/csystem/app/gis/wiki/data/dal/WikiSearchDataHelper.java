package org.csystem.app.gis.wiki.data.dal;

import lombok.extern.slf4j.Slf4j;
import org.csystem.app.gis.wiki.data.entity.WikiSearch;
import org.csystem.app.gis.wiki.data.entity.WikiSearchInfo;
import org.csystem.app.gis.wiki.data.repository.IWikiSearchInfoRepository;
import org.csystem.app.gis.wiki.data.repository.IWikiSearchRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        try {
            var wikiSearch = new WikiSearch();

            wikiSearch.queryText = queryText;
            var ws = m_wikiSearchRepository.save(wikiSearch);

            wikiSearchInfo.stream().peek(wi -> wi.wikiSearch = ws).forEach(m_wikiSearchInfoRepository::save);
        }
        catch (Throwable ex) {
            log.error("Exception occurred WikiSearchDataHelper.saveWikiSearchInfo:{}", ex.getMessage());
            throw ex;
        }
    }

    public List<WikiSearchInfo> findWikiSearchInfoByQueryText(String queryText, int dataPerPage, int pageNumber)
    {
        try {
            return m_wikiSearchInfoRepository.findByQueryText(queryText, PageRequest.of(pageNumber, dataPerPage)).getContent();
        }
        catch (Throwable ex) {
            log.error("Exception occurred WikiSearchDataHelper.findWikiSearchInfoByQueryText:{}", ex.getMessage());
            throw ex;
        }
    }
}
