package org.csystem.app.gis.wiki.data.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "wiki_searches")
@EqualsAndHashCode
@ToString
public class WikiSearch {
    @Id
    @Column(length = 512)
    public String queryText;

    @Column(nullable = false)
    public LocalDateTime firstQueryDateTime = LocalDateTime.now();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wikiSearch", cascade = CascadeType.ALL)
    public Set<WikiSearchInfo> wikiSearchInfo;
}
