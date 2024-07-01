package com.scullincw.spring.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JwtTest {

    //私钥 生成签名的时候使用的秘钥secret，一般可以从本地配置文件中读取
    private final static String secret = "123456789";

    /**
     * 创建jwt
     */
    public static String createJwtToken(){
        // Header
        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");

        //Payload
        Map<String,Object> claims = new HashMap<>();

        //自定义数据，根据业务需要添加
        claims.put("id","123456");
        claims.put("userName", "admin");

        //标准中注册的声明
        claims.put("iss", "lee");

        //生成jwt
        return Jwts.builder()
                .setHeader(header)         // 添加Header信息
                .setClaims(claims)      // 添加Payload信息
                .setId(UUID.randomUUID().toString()) // 设置jti：是JWT的唯一标识
                .setIssuedAt(new Date())       // 设置iat: jwt的签发时间
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 设置exp：jwt过期时间，3600秒=1小时
                .setSubject("Jack")    //设置sub：代表这个jwt所面向的用户
                .signWith(SignatureAlgorithm.HS256, secret)//设置签名：通过签名算法和秘钥生成签名
                .compact();
    }

    /**
     * 从jwt中获取 Payload 信息
     */
    private static Claims getClaimsFromJwt(String jwt) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(jwt).getBody();
    }

    public static void main(String[] args) {
        String jwtToken = createJwtToken();
        System.out.println("JWT Token: "+ jwtToken);
        System.out.println("=======================================================");

        Claims claims = getClaimsFromJwt(jwtToken);
        System.out.println("claims: " + claims);
    }
}