package com.example.event.config;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
                return new TripleException(Code.BAD_REQUEST);
            case 404:
                return new TripleException(Code.NOT_FOUND);
            default:
                return new TripleException(Code.SERVER_ERROR);
        }
    }
}
