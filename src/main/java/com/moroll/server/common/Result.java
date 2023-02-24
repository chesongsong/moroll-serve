package com.moroll.server.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

/**
 * @author :  chesongsong
 * @Description :  TODO
 * @Creation Date:  2023-02-22 00:02
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {
    private int code;
    private String msg;
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private T data;

    public Result() {
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static Result success(Object data){
        return new Result(200,"操作成功!", data);
    }
    public static Result success(String msg){
        return new Result(200,msg, null);
    }
    public static Result success(String msg,Object data){
        return new Result(HttpStatus.OK.value(), msg, data);
    }

    public static Result error(Integer code,String msg, Object data){
        return new Result(code, msg, data);
    }
    public static Result error(Integer code,String msg){
        return new Result(code, msg, null);
    }
    public static Result error(String msg){
        return new Result(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, null);
    }
}
