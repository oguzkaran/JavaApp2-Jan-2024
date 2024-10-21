package org.csystem.app.gis.wiki.rest.exception.response;

import java.time.LocalDateTime;

public class BlankStringResponse extends ErrorResponse {
    public BlankStringResponse(int status, LocalDateTime errorDateTime, String details)
    {
        super(status, errorDateTime, details);
    }
}
