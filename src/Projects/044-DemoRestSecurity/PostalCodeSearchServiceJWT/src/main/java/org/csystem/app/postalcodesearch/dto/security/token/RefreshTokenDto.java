package org.csystem.app.postalcodesearch.dto.security.token;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.Instant;

@Getter
@Setter
@Accessors(prefix = "m_")
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RefreshTokenDto {
    private String m_username;
    private String m_token;
    private Instant m_expiryDateTime;
}
