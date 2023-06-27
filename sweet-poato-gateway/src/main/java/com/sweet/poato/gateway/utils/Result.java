package com.sweet.poato.gateway.utils;

import com.sweet.poato.gateway.code.ResultCode;

import java.io.Serializable;

/**
 * @Author: TheSunshine
 * @Date: 2022/8/6 17:35
 * @Version 1.0
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 是否成功
     */
    private Boolean isSuccess;

    /**
     * 返回消息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    /**
     * 响应编码
     */
    private Integer code;


    public static Result success(Integer code,String message){
        Result result = new Result();
        result.code = code;
        result.message = message;
        result.isSuccess = true;
        return result;
    }

    public static<T>Result success(String message,T data){
        Result<T> result = new Result<T>();
        result.isSuccess = true;
        result.data = data;
        result.message = message;
        result.code = 0;
        return result;
    }

    public static Result error(Integer code,String message){
        Result result = new Result();
        result.code = code;
        result.message = message;
        result.isSuccess = false;
        return result;
    }

    public static<T>Result error(String message,T data){
        Result<T> result = new Result<T>();
        result.isSuccess = false;
        result.data = data;
        result.message = message;
        result.code = 500;
        return result;
    }

    public static<T> Result forbidden(T data){
        Result<T> result = new Result<T>();
        result.isSuccess = false;
        result.data = data;
        result.message = ResultCode.FORBIDDEN.getMessage();
        result.code = ResultCode.FORBIDDEN.getCode();
        return result;
    }

    public static<T> Result unauthorized(T data){
        Result<T> result = new Result<T>();
        result.isSuccess = false;
        result.data = data;
        result.message = ResultCode.UNAUTHORIZED.getMessage();
        result.code = ResultCode.UNAUTHORIZED.getCode();
        return result;
    }
    public Result(){}

    public Result(Boolean isSuccess, String message, T data, Integer code) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.data = data;
        this.code = code;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


}
