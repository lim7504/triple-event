package com.example.event.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {

        String message = null;
        InputStream responseBodyIs = null;
        try {
            responseBodyIs = response.body().asInputStream();
            ObjectMapper mapper = new ObjectMapper();
            ExceptionMessage exceptionMessage = mapper.readValue(responseBodyIs, ExceptionMessage.class);

            message = exceptionMessage.message;

        } catch (IOException e) {

            e.printStackTrace();
            // you could also return an exception

        }finally {

            //It is the responsibility of the caller to close the stream.
            try {
                if (responseBodyIs != null)
                    responseBodyIs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        switch (response.status()) {
            case 400:
                return new TripleException(Code.BAD_REQUEST);
            case 404:
                return new TripleException(Code.NOT_FOUND);
            default:
                return new TripleException(Code.SERVER_ERROR);
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class ExceptionMessage{

        private String timestamp;
        private int status;
        private String error;
        private String message;
        private String path;

    }
}
