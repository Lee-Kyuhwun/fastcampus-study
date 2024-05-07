package dev.be.jwt.service;


import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class JwtService {

    private static String secretKey ="java11SpringBootJWTTOKENIssueMethod";

    public String create(

            Map<String, Object> claims,
            LocalDateTime expireAt
    ) {

        var key = Keys.hmacShaKeyFor(secretKey.getBytes());
        var _expireAt = Date.from(expireAt.atZone(ZoneId.systemDefault()).toInstant());// Date.from() 메서드는 LocalDateTime 타입을 Date 타입으로 변환합니다.
        // ZoneId.systemDefault() 메서드는 시스템의 기본 시간대를 반환합니다. 이 시간대는 시스템의 설정에 따라 변경될 수 있습니다.

        return Jwts.builder()
                .signWith(key, SignatureAlgorithm.HS256) // signWith() 메서드는 JWT를 생성할 때 사용할 암호화 알고리즘을 설정합니다. key는 암호화에 사용할 비밀키입니다.
                .setClaims(claims) // setClaims() 메서드는 JWT의 payload를 설정합니다. payload는 Map<String, Object> 타입으로 전달합니다.
                .setExpiration(_expireAt) // setExpiration() 메서드는 JWT의 만료 시간을 설정합니다. 만료 시간은 java.sql.Timestamp 타입으로 전달합니다.
                .compact(); // compact() 메서드는 설정한 정보를 기반으로 JWT를 생성하고 반환합니다.
    }

    public void validation(String token) {
        var key = Keys.hmacShaKeyFor(secretKey.getBytes());
        var parser = Jwts.parser()
                .setSigningKey(key)
                .build();

        try{
            var result = parser.parseClaimsJws(token);
            result.getBody().entrySet().forEach(value -> { // entrySet() 메서드는 Map의 key와 value를 Set 타입으로 반환합니다.
                log.info("key: {}, value: {}", value.getKey(), value.getValue()); // getKey() 메서드는 Map의 key를 반환합니다.
            });
        }catch (Exception e){
            if(e instanceof SignatureException) // instanceof 연산자는 객체가 특정 클래스의 인스턴스인지 확인합니다.
            {
                log.error("서명이 일치하지 않음");
            }else if (e instanceof ExpiredJwtException){
                log.error("토큰 만료");
            }else{
                throw new RuntimeException("JWT 검증 오류");
            }
        }



    }
}
