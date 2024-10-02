package org.csystem.app.gis.wiki.rest.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GeoWikiSearchDTO {
    public List<GeoWikiSearchInfoDTO> geoWikiInfo;
}
