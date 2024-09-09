package org.csystem.app.gis.wiki.geonames.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GeonamesWikiSearchInfo {
    public String summary;
    public double elevation;
    public int geoNameId;
    public String feature;
    @JsonProperty("lng")
    public double longitude;
    public String countryCode;
    public int rank;
    public String thumbnailImg;
    public String lang;
    public String title;
    @JsonProperty("lat")
    public double latitude;
    public String wikipediaUrl;
}