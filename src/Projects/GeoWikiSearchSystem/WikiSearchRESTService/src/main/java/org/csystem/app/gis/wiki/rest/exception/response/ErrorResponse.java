package org.csystem.app.gis.wiki.rest.exception.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    @Accessors(prefix = "m_")
    private int m_status;
    @Accessors(prefix = "m_")
    private LocalDateTime m_errorDateTime;
    @Accessors(prefix = "m_")
    private String m_details;


}
