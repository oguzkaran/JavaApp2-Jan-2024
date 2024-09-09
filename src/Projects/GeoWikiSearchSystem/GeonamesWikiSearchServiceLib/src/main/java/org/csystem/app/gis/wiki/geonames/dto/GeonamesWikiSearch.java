package org.csystem.app.gis.wiki.geonames.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class GeonamesWikiSearch {
    @JsonProperty("geonames")
    public List<GeonamesWikiSearchInfo> wikiInfo;
}
