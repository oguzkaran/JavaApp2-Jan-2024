package org.csystem.app.gis.wiki.rest.exception;

import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.util.Arrays;
import java.util.stream.Collectors;


public class NegativeIntException extends RestException {
    @Serial
    private static final long serialVersionUID = 1L;

    @Accessors(prefix = "m_")
    private final int [] m_values;

    public NegativeIntException(String message, int...values)
    {
        super(message, HttpStatus.BAD_REQUEST);
        m_values = Arrays.copyOf(values, values.length);
    }

    public int size()
    {
        return m_values.length;
    }

    public int get(int i)
    {
        return m_values[i];
    }

    @Override
    public String getMessage()
    {
        var values = Arrays.stream(m_values).mapToObj(String::valueOf).collect(Collectors.joining(", "));

        return "Negative Number Exception:%s -> Value:%s".formatted(super.getMessage(), values);
    }
}
