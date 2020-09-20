package com.core.client;

import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

import static com.common.Constants.TimeOuts.DEFAULT_TIMEOUT;

public class HttpClient {

    @Bean
    public OkHttpClient client() {
        return new feign.okhttp.OkHttpClient(new okhttp3.OkHttpClient().newBuilder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
                .followRedirects(true)
                .retryOnConnectionFailure(true)
                .build());
    }
}
