package org.csystem.app.gis.wiki.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class WikiSearchInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wiki_search_info_id")
    public long id;

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

    //...
}
