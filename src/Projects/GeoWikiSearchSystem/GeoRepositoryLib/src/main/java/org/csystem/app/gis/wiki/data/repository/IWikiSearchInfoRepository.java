package org.csystem.app.gis.wiki.data.repository;

import org.csystem.app.gis.wiki.data.entity.WikiSearchInfo;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IWikiSearchInfoRepository extends JpaRepository<WikiSearchInfo, Long> {
    @Query(value = "from WikiSearchInfo  wi where wi.wikiSearch.queryText = :queryText")
    Page<WikiSearchInfo> findByQueryText(@Param("queryText") String queryText, @Param("pageable") Pageable pageable);

}

