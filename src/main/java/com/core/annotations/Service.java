package com.core.annotations;


import com.core.client.HttpClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for interfaces declaring that a REST client with that interface should be
 * created (e.g. for Autowiring into another component).
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@FeignClient(configuration = HttpClient.class)
public @interface Service {

    /**
     * Alias for {@link FeignClient#name}.
     */
    @AliasFor(annotation = FeignClient.class)
    String name() default "";

    /**
     * Alias for {@link FeignClient#url}.
     */
    @AliasFor(annotation = FeignClient.class)
    String url() default "";
}
