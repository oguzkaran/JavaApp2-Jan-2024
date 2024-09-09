package org.csystem.app.gis.wiki.data.repository;

import org.csystem.app.gis.wiki.data.entity.WikiSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWikiSearchRepository extends JpaRepository<WikiSearch, String> {

}
