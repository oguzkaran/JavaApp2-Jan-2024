package org.csystem.app.gis.wiki.data.repository;

import org.csystem.app.gis.wiki.data.entity.WikiSearchInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IWikiSearchInfoRepository extends JpaRepository<WikiSearchInfo, Long> {
    @Query()
    Iterable<WikiSearchInfo> findByQueryText(@Param("queryText") String queryText);
}

