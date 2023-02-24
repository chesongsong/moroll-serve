package com.moroll.server.handler;

import com.moroll.server.common.Result;
import com.moroll.server.entity.SysUser;
import com.moroll.server.utils.JwtUtil;
import com.moroll.server.utils.RedisCache;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author :  chesongsong
 * @Description :  TODO
 * @Creation Date:  2023-02-23 19:04
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String BearerToken = request.getHeader("authorization");
        String token = "";
        if(StringUtils.hasText(BearerToken)){
            token = BearerToken.replace("Bearer","").trim();
        }
        // 没有token 交给下一个过滤器处理
        if(!StringUtils.hasText(token)){
            filterChain.doFilter(request, response);
            return;
        }
        if(StringUtils.hasText(token) && !JwtUtil.isTokenExpired(token)){
            // 从token中获取用户id
            Claims claims = JwtUtil.parseToken(token);
            String userId = (String) claims.get("uid");
            // 从Redis中查找用户信息和权限信息
            String redisKey = "login:" + userId;
            SysUser user = redisCache.getCacheObject(redisKey);
            // 如果找到用户信息，则将其存储到SecurityContext中
            if (user != null) {
                // 创建认证对象
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                // 将认证对象存储到SecurityContext中，便于下个过滤器使用
                SecurityContextHolder.getContext().setAuthentication(authentication);
                filterChain.doFilter(request, response);
            }else{
                // 未找到用户信息，未登录，下线
                throw new RuntimeException("未找到用户登录信息信息");
            }
        }else {
            throw new RuntimeException("token验证失败");
        }


    }
}