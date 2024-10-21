package org.csystem.app.gis.wiki.rest.exception;

import org.springframework.http.HttpStatus;

import java.io.Serial;

public class BlankStringException extends RestException {
    @Serial
    private static final long serialVersionUID = 1L;

    public BlankStringException()
    {
        this("");
    }

    public BlankStringException(String message)
    {
        super(message, HttpStatus.BAD_REQUEST);
    }

    @Override
    public String getMessage()
    {
        return "String Blank Exception:%s".formatted(super.getMessage());
    }
}
