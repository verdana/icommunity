package com.modoop.rest.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Genkyo Lee
 */
public class RestException extends RuntimeException
{
    private static final long serialVersionUID = 3918400872935689341L;

    public HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    public RestException()
    {
    }

    public RestException(HttpStatus status)
    {
        this.status = status;
    }

    public RestException(String message)
    {
        super(message);
    }

    public RestException(HttpStatus status, String message)
    {
        super(message);
        this.status = status;
    }
}
