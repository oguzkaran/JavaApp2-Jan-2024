package org.csystem.app.gis.wiki.rest.exception;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class RestException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    @Accessors(prefix = "m_")
    private final HttpStatus m_httpStatus;

    public RestException(String message, HttpStatus httpStatus)
    {
        super(message);
        m_httpStatus = httpStatus;
    }

    @Override
    public String getMessage()
    {
        return "Message:%s, Status:%s, Status Code:%d".formatted(super.getMessage(), m_httpStatus, m_httpStatus.value());
    }
}
