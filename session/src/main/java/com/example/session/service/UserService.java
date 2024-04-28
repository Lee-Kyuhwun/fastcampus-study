package com.example.session.service;


import com.example.session.model.LoginRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void login(
            LoginRequest loginRequest,
            HttpSession httpSession
    ){

    }
}
