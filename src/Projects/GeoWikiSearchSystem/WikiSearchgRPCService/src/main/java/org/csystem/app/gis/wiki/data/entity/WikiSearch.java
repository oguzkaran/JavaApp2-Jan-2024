package org.csystem.app.gis.wiki.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class WikiSearch {
    @Id
    public String queryText;

    @Column(nullable = false)
    public LocalDateTime firstQueryDateTime = LocalDateTime.now();


}
