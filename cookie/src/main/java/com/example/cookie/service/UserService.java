package com.example.cookie.service;


import com.example.cookie.database.UserRepository;
import com.example.cookie.model.LoginRequest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void login(
            LoginRequest loginRequest,
            HttpServletResponse httpServletResponse
    ){
        var id = loginRequest.getId();
        var pw = loginRequest.getPassword();

        var optionalUser = userRepository.findByUserName(id);

        if(optionalUser.isPresent()){
            var userDto = optionalUser.get();

            if(userDto.getPassword().equals(pw)){
                // 쿠키에 저장
                var cookie =  new Cookie("authorization-cookie", userDto.getId());
                cookie.setDomain("localhost"); //naver.com 등등 도메인 여기다가 입력 dev.xxx.com << production.xxx.com
                cookie.setPath("/"); // / 하위 모든 경로에서 쿠키 사용 가능
                cookie.setHttpOnly(true); // 자바스크립트로 쿠키 접근 불가
                cookie.setMaxAge(-1); // 브라우저 종료시 쿠키 삭제
                cookie.setSecure(true); // https에서만 쿠키 전송
                httpServletResponse.addCookie(cookie);

                
            }else{
                throw new RuntimeException("Password Not Match");
            }


        }else {
            //없는 유저
            throw new RuntimeException("User Not Found");


        }
    }
}
