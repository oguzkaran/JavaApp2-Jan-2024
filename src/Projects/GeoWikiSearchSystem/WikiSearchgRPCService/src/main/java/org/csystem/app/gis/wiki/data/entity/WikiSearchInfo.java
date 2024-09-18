package org.csystem.app.gis.wiki.data.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "wiki_search_info")
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class WikiSearchInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wiki_search_info_id")
    public long id;

    @Column(length = 1024)
    public String summary;

    public double elevation;
    public int geoNameId;
    public String feature;
    public double longitude;
    public String countryCode;
    public int rank;
    public String thumbnailImg;
    public String lang;
    public String title;
    public double latitude;
    public String wikipediaUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "query_text", nullable = false)
    public WikiSearch wikiSearch;
}
