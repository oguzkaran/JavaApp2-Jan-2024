package org.csystem.app.postalcodesearch.dto.payment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(prefix = "m_")
@Builder
public class PostalCodes {
    private List<PostalCodeInfo> m_postalCodes;
}
