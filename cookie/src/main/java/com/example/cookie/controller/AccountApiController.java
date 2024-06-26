package com.example.cookie.controller;

import com.example.cookie.model.LoginRequest;
import com.example.cookie.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountApiController{

    private final UserService userService;

    @PostMapping("/login")
    public String login(
            @RequestBody
            LoginRequest loginRequest,
            HttpServletResponse httpServletResponse // HttpServletResponse은 응답을 할 때 사용하는 객체
            , HttpSession httpSession
    ){
       return userService.login(loginRequest, httpServletResponse);
    }



}
