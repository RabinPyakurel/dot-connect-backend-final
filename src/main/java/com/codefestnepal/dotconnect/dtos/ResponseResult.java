package com.codefestnepal.dotconnect.dtos;

public class ResponseResult<T> {
    private boolean success;
    private String message;
    private T data;

    public ResponseResult(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static  <TData> ResponseResult<TData> SuccessResult(TData obj){
        return new ResponseResult<>(true, null, obj);
    }

    public static  <TData> ResponseResult<TData> FailedResult(String message){
        return new ResponseResult<>(false, message
                , null);
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
