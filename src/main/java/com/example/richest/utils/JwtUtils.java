package com.example.richest.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
@ConfigurationProperties(prefix = "markerhub.jwt")
public class JwtUtils {
    private String secret;
    private long expire;
    private String header;


    // 过期时间5分钟
    private static final long EXPIRE_TIME = 50*60*1000;

    /**
     * 生成jwt token
     * @param id
     */
    public String generateToken(Long id) {
            JwtBuilder jwtBuilder = Jwts.builder()
                    .setSubject(id+"")
                    .setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256,"lois")//头部
                    .setExpiration(new Date(new Date().getTime()+EXPIRE_TIME))//过期时间为1分钟
                    .claim("role","admin");//自定义信息
            return jwtBuilder.compact();


    }

    // 获取jwt的信息
    public Claims getClaimByToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey("lois")
                .parseClaimsJws(token)
                .getBody();

        return claims;

    }

    /**
     * token是否过期
     * @return  true：过期
     */
    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }




}
