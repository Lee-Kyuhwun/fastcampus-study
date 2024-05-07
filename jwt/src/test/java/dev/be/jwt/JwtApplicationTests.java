package dev.be.jwt;

import dev.be.jwt.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Objects;

@SpringBootTest
class JwtApplicationTests {

    @Autowired
    private JwtService jwtService;

    @Test
    void contextLoads() {
    }


    @Test
    void tokenCreate(){
        var claims = new HashMap<String, Object>();
        claims.put("userId", 923);
        var expireAt = LocalDateTime.now().plusMinutes(10);
        var jwtToken = jwtService.create(claims, expireAt);
        System.out.println("jwtToken = " + jwtToken);
    }

    @Test
    void tokenValidation(){
        var token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjkyMywiZXhwIjoxNzE1MDk0NTk3fQ.dRnfOFKKtQNO1kQ7UsAswm7J8krwj2-RipIElSuQA9U";

        jwtService.validation(token);
    }
}
