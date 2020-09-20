package com.core.exceptions;

import feign.Response;
import feign.Util;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public final class StringUtils {

    public static List<String> splitAsList(String value) {
        return value != null ? Arrays.asList(value.split("\\s*,\\s*")) : null;
    }

    public static String responseToString(Response.Body response) {
        try {
            return Util.toString(response.asReader());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
