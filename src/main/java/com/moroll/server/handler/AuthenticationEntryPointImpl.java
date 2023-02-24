package com.moroll.server.handler;

import com.alibaba.fastjson.JSON;
import com.moroll.server.common.Result;
import com.moroll.server.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author :  chesongsong
 * @Description :  TODO
 * @Creation Date:  2023-02-23 19:57
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        String msg = "未登录";
        if(authException instanceof BadCredentialsException) {
            msg = "账号或密码错误";
        }
         Result result = new Result(HttpStatus.UNAUTHORIZED.value(),msg);
        String json = JSON.toJSONString(result);
        //处理异常
        WebUtils.renderString(response,json);
    }
}