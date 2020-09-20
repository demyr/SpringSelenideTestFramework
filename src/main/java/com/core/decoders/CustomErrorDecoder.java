//package com.core.decoders;
//
//import com.core.exceptions.UnableToCreateEntityException;
//import com.core.exceptions.UnableToDeleteEntityException;
//import com.core.exceptions.UnableToReadEntityException;
//import com.core.exceptions.UnableToUpdateEntityException;
//import feign.Request.HttpMethod;
//import feign.Response;
//import feign.codec.ErrorDecoder;
//import org.springframework.stereotype.Component;
//
//import static io.vavr.API.*;
//
//@Component
//public class CustomErrorDecoder implements ErrorDecoder {
//
//    private final ErrorDecoder defaultErrorDecoder = new Default();
//
//    @Override
//    public Exception decode(String methodKey, Response response) {
//
//        return Match(response.request().httpMethod()).of(
//                Case($(HttpMethod.GET), () -> new UnableToReadEntityException(response)),
//                Case($(HttpMethod.POST), () -> new UnableToCreateEntityException(response)),
//                Case($(HttpMethod.PUT), () -> new UnableToUpdateEntityException(response)),
//                Case($(HttpMethod.DELETE), () -> new UnableToDeleteEntityException(response)),
//                Case($(), () -> defaultErrorDecoder.decode(methodKey, response)));
//    }
//}
