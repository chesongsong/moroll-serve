package com.moroll.server.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * @author :  chesongsong
 * @Description :  TODO
 * @Creation Date:  2023-02-22 00:05
 */
public class JwtUtil {
    // token  过期时间 72 小时
    private static long TOKEN_EXPIRATION = 3 * 24 * 60 * 60 * 1000;
    private static final String SECRET_KEY = "moroll-base-server"; // 用于生成和解析 JWT 的密钥

    // 生成 JWT
    public static String generateToken(Map<String, Object> claims) {
        long currentTimeMillis = System.currentTimeMillis();
        //过期时间
        Date expirationDate = new Date(currentTimeMillis + TOKEN_EXPIRATION);
        return Jwts.builder()
                .setClaims(claims) // 设置自定义的键值对
                .setExpiration(expirationDate) // 设置过期时间
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY) // 设置加密算法和密钥
                .compact();
    }

    // 解析 JWT
    public static Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY) // 设置密钥
                .parseClaimsJws(token) // 解析 JWT
                .getBody();
    }

    // 验证 JWT 是否过期
    public static boolean isTokenExpired(String token) {
        try {
            final Date expiration = parseToken(token).getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return true;
        }
    }
}