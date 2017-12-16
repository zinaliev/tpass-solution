package com.genesys.tpass.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponseDto<T>{

    private String message;

    private StatusCode code;

    private T data;

    public T getData() {
        return data;
    }

    public ApiResponseDto setData(T data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ApiResponseDto setMessage(String message) {
        this.message = message;
        return this;
    }

    public StatusCode getCode() {
        return code;
    }

    public ApiResponseDto setCode(StatusCode code) {
        this.code = code;
        return this;
    }

    public static ApiResponseDto notImplemented(String methodName){
        return new ApiResponseDto()
                .setCode(StatusCode.NOT_IMPLEMENTED)
                .setMessage("method '" + methodName + "' is not implemented");
    }
}
