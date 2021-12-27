package com.example.event.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ResponseResult<T> {

    private String code;

    private T data;

    private String message;

    private LocalDateTime timeStamp = LocalDateTime.now();

    @JsonIgnore
    private HttpStatus httpStatus;

    public ResponseResult(Code code) {
        this.code = code.getCode();
        this.message = code.getMessage();
    }

    public ResponseResult(String message) {
        this.code = Code.SERVER_ERROR.getCode();
        this.message = message;
    }

    public static <T> ResponseResult<T> ok() {
        return ok(null, null);
    }

    public static <T> ResponseResult<T> ok(T data) {
        return ok(data, null);
    }

    public static <T> ResponseResult<T> ok(T data, String message) {
        return with(data).code(Code.SUCCESS).message(message).httpStatus(HttpStatus.OK);
    }

    public static <T> ResponseResult<T> fail(@NotNull Code code) {
        return with((T) null).code(code).httpStatus(code.getStatus());
    }

    public static <T> ResponseResult<T> fail(@NotNull Code code, T data) {
        return with(data).code(code).httpStatus(code.getStatus());
    }

    public static <T> ResponseResult<T> fail(@NotNull Code code, String message) {
        return with((T) null).code(code).message(message).httpStatus(code.getStatus());
    }

    public static <T> ResponseResult<T> fail(Code code, String message, HttpStatus httpStatus) {
        return with((T) null).code(code).message(message).httpStatus(httpStatus);
    }


    private static <T> ResponseResult<T> with(T data) {
        ResponseResult<T> response = new ResponseResult<>();
        response.data = data;
        return response;
    }

    public ResponseResult<T> code(@NotNull Code code) {
        this.code = code.getCode();
        return this;
    }

    public ResponseResult<T> message(String message) {
        this.message = message;
        return this;
    }

    public ResponseResult<T> httpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    public ResponseEntity createResponseEntity() {
        return ResponseEntity.status(HttpStatus.OK).body(this);
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.code.equals(Code.SUCCESS.getCode());
    }
}