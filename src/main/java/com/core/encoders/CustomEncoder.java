//package com.core.encoders;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import feign.codec.Encoder;
//import org.springframework.beans.factory.ObjectFactory;
//import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
//import org.springframework.cloud.openfeign.support.SpringEncoder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.stereotype.Component;
//
//import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
//import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;
//
//@Component
//public class CustomEncoder {
//
//    @Bean
//    public Encoder encoder() {
//        var converter = new MappingJackson2HttpMessageConverter(getMapper());
//        ObjectFactory<HttpMessageConverters> factory = () -> new HttpMessageConverters(converter);
//
//        return new SpringEncoder(factory);
//    }
//
//    /**
//     * Serialize Java objects into JSON and deserialize JSON string into Java objects
//     * {@link ObjectMapper}
//     */
//
//    @Bean
//    private ObjectMapper getMapper() {
//        return new ObjectMapper()
//                .findAndRegisterModules()
//                .setVisibility(FIELD, ANY)
//                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
//                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
//    }
//}
