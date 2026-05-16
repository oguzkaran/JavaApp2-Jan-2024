package org.csystem.app.postalcodesearch.dto.payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(prefix = "m_")
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostalCodeInfo {
    public String m_adminCode2;
    public String m_adminCode1;
    public String m_adminName2;
    public double m_lng;
    public String m_countryCode;
    public String m_postalCode;
    public String m_adminName1;
    public String m_placeName;
    public double m_lat;
    public String m_adminCode3;
    public String m_adminName3;
}
