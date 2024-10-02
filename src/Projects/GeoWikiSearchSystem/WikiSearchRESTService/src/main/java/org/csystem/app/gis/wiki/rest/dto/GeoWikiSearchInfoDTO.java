package org.csystem.app.gis.wiki.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class GeoWikiSearchInfoDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String summary;

    public double elevation;

    public int geoNameId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String feature;

    public double longitude;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String countryCode;

    public int rank;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String thumbnailImg;

    public String lang;

    public String title;

    public double latitude;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String wikipediaUrl;
}
