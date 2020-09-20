package com.core.exceptions;

import feign.Response;

import static com.core.exceptions.StringUtils.responseToString;
import static java.lang.String.format;

public class UnableToCreateEntityException extends RuntimeException {

    public UnableToCreateEntityException(Response response) {
        super(format("\nRequest: \n%s \n%s \n%s \n\nResponse: \n%s %s %s",
                response.request().httpMethod() + " " + response.request().url(), response.request().headers(),
                new String(response.request().requestBody().asBytes()),
                response.status(), response.reason(), response.body() != null ? responseToString(response.body()) : ""));
    }
}
