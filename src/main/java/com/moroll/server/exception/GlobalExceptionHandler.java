package com.moroll.server.exception;

import com.moroll.server.common.Result;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author :  chesongsong
 * @Description :  TODO
 * @Creation Date:  2023-02-23 19:48
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Result handleBindException(MethodArgumentNotValidException e){
    System.out.println(e.getBindingResult().getFieldErrors().toString());
        String msg = e.getBindingResult().getFieldErrors()
                .stream()
                .map(n -> String.format("%s: %s", n.getField(), n.getDefaultMessage()))
                .reduce((x, y) -> String.format("%s; %s", x, y))
                .orElse("参数输入有误");
        return new Result(HttpStatus.BAD_REQUEST.value(), msg);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<String> handleException(Exception e) {
        // 返回自定义的错误信息
        return new Result(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

}
