package org.csystem.app.gis.wiki.rest.exception.handler;

import io.grpc.StatusRuntimeException;
import org.csystem.app.gis.wiki.rest.exception.BlankStringException;
import org.csystem.app.gis.wiki.rest.exception.NegativeIntException;
import org.csystem.app.gis.wiki.rest.exception.response.BlankStringResponse;
import org.csystem.app.gis.wiki.rest.exception.response.ErrorResponse;
import org.csystem.app.gis.wiki.rest.exception.response.NegativeIntResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

@ControllerAdvice
public class WikiSearchExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<BlankStringResponse> handleException(BlankStringException ex)
    {
        var response = new BlankStringResponse(HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(), ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE)
    public @ResponseBody NegativeIntResponse handleException(NegativeIntException ex)
    {
        return new NegativeIntResponse(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE.value(), LocalDateTime.now(), ex.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public @ResponseBody ErrorResponse handleException(StatusRuntimeException ex)
    {
        return new ErrorResponse(HttpStatus.NOT_ACCEPTABLE.value(), LocalDateTime.now(), ex.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleException(MethodArgumentTypeMismatchException ex)
    {
        return new ErrorResponse(HttpStatus.NOT_ACCEPTABLE.value(), LocalDateTime.now(), ex.getMessage());
    }
}
