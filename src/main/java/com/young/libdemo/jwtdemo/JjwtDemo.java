package com.young.libdemo.jwtdemo;

import io.jsonwebtoken.*;
import jdk.nashorn.internal.parser.Token;

import java.util.Calendar;
import java.util.Date;

/**
 * @author yangzongxu
 * @date 2018/9/30
 * @description jjwt demo
 */
public class JjwtDemo {

    private static final String SECRET = "DyoonSecret_0581";

    private static String getJwtToken() {
        Date iastDate = new Date();
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.DATE, 10);
        Date expiresDate = nowTime.getTime();
        Claims claims = Jwts.claims();
        claims.put("name", "yzx");
        claims.put("userId", "222");
        claims.setAudience("yzx");
        claims.setIssuer("yzx");
        String token = Jwts.builder().setClaims(claims).setExpiration(expiresDate)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
        return token;

    }

    public static void parseJwtToken(String token) {
        Jws<Claims> jws = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
        String signature = jws.getSignature();
        System.out.println(signature);
        System.out.println("--");
        JwsHeader header = jws.getHeader();
        System.out.println(header);
        System.out.println("--");
        Claims claims = jws.getBody();
        System.out.println(claims);
    }


    public static void main(String[] args) {
        String jwtToken = getJwtToken();
        parseJwtToken(jwtToken);


    }
}


