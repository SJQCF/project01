package com.sjqcf;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testJwt(){
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id","1");
        dataMap.put("username","admin");

        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256,"U0pRQ0Y=")//签名算法和密钥(U0pRQ0Y=)
                .addClaims(dataMap)//添加数据
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//过期时间
                .compact();//构建

        System.out.println(jwt);
    }

    @Test
    public void tesJwt2(){
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6IjEiLCJ1c2VybmFtZSI6ImFkbWluIiwiZXhwIjoxNzYzOTU2NTE3fQ.BvWStb_R2_G8nal083QEcWtNdCAoEFu0WP2a7jd5O9A";
        Claims claims = Jwts.parser()
                .setSigningKey("U0pRQ0Y=")//密钥
                .parseClaimsJws(jwt)
                .getBody();
        System.out.println(claims);
    }
}
