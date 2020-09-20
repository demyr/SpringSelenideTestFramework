package com.core.exceptions;

import feign.Response;

import static com.core.exceptions.StringUtils.responseToString;
import static java.lang.String.format;

public class UnableToReadEntityException extends RuntimeException {

    public UnableToReadEntityException(Response response) {
        super(format("\nRequest: \n%s \n\nResponse: \n%s %s %s",
                response.request().toString(),
            response.status(), response.reason(), response.body() != null ? responseToString(response.body()) : ""));
    }
}
