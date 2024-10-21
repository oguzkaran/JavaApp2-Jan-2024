package org.csystem.app.gis.wiki.rest.exception.response;

import java.time.LocalDateTime;

public class NegativeIntResponse extends ErrorResponse {
    public NegativeIntResponse(int status, LocalDateTime errorDateTime, String details)
    {
        super(status, errorDateTime, details);
    }
    //...
}
