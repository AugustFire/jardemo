package com.young.libdemo.jwtdemo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangzongxu
 * @date 2018/9/26
 * @description jwt测试
 */
public class JwtDemo {

    public static final String SECRET = "JKKLJOoasdlfj";
    public static final int calendarField = Calendar.DATE;
    public static final int calendarInterval = 10;

    public static String createToken(Long userId){
        Date iatDate = new Date();
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(calendarField, calendarInterval);
        Date expireDate = nowTime.getTime();

        //header map
        HashMap<String, Object> map = new HashMap<>(4);
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create().withHeader(map)
                .withClaim("iss", "Service")
                .withClaim("aud", "APP")
                .withClaim("user_id", null == userId ? null : userId.toString())
                .withIssuedAt(iatDate)
                .withExpiresAt(expireDate)
                .sign(Algorithm.HMAC256(SECRET));

        return token;
    }

    public static Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt = null;

        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);
        } catch (IllegalArgumentException | JWTVerificationException e) {
            //token 校验失效
            e.printStackTrace();
        }
        return jwt.getClaims();
    }

    public static Long getAppID(String token) {
        Map<String, Claim> claims = verifyToken(token);
        Claim userId = claims.get("user_id");
        if (userId.isNull()) {
            //校验失败
        }
        return Long.valueOf(userId.asString());

    }


    public static void main(String[] args) {
        String token = createToken(13451278638L);
        System.out.println(token);
        Long appID = getAppID(token);
        System.out.println(appID);
    }

}
