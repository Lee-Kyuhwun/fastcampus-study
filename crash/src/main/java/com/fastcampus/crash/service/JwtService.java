package com.fastcampus.crash.service;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

@Service
@Slf4j
public class JwtService {



    private final SecretKey key;

    public JwtService(@Value("${jwt.secret-key}") String key){
        this.key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));
    }

    public String generateAccessToken(UserDetails userDetails) {
        return generateToken(userDetails.getUsername());
    }


    public String getUsername(String accessToken) {
        return getSubject(accessToken);
    }


    private String generateToken(String subject){ // subject로 username을 받아서 토큰을 생성
        var now  = new Date();
        var exp = new Date(now.getTime() + (1000 * 60 * 60 * 24 * 7)); // 7일
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now) // 만료시간은 현재시간부터 7일
                .setExpiration(exp)
                .signWith(key)
                .compact();

    }


    // subject 추출
    public String getSubject(String token){
        try{
            return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject();

        }catch (Exception e){
            log.error(e.getMessage());
            throw e;
        }
    }


}
