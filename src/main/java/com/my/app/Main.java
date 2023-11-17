package com.my.app;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.Duration;
import java.util.Date;

public class Main {

    public static final Duration EXPIRE_IN = Duration.ofDays(7);

    public static final String APP_SECRET = "1e5503b52dd944eef7ebab10fd9ae2221e5d53b52f0944eef7ebab97fd9ae105";

    public static void example() {
        JwtBuilder builder = Jwts.builder()
                .setHeaderParam("version", "2.0")
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setSubject("my-token").setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_IN.toMillis()));

        // 添加熟悉
        builder.claim("client_id", "test_client_id");
        builder.claim("app_version", "1.0.0");
        builder.signWith(SignatureAlgorithm.HS256, APP_SECRET);
        String tokenValue = builder.compact();
        System.out.println(tokenValue);


    }


    public static void main(String[] args) {

        example();

    }
}
