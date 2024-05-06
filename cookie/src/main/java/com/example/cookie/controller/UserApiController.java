package com.example.cookie.controller;


import com.example.cookie.database.UserRepository;
import com.example.cookie.model.UserDto;
import com.example.cookie.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Slf4j
public class UserApiController {

    private final UserService userService;
    private final UserRepository userRepository;


    @GetMapping("/me")
    public UserDto me(HttpServletRequest httpServletRequest,
                      @CookieValue(name = "authorization-cookie", required = false) // required = false : 쿠키가 없어도 에러가 발생하지 않음
                      String authorizationCookie
    ) {
        log.info("authorizationCookie : {}", authorizationCookie);

        var optionalUserDto = userRepository.findById(authorizationCookie);

        return optionalUserDto.get();


    }

    @GetMapping("/me2")
    public UserDto me2(HttpServletRequest httpServletRequest,
                        @RequestHeader(name = "authorization", required = false)
                       String authorizationHeader
    ) {
        log.info("authorizationHeader : {}", authorizationHeader);

        var optionalUserDto = userRepository.findById(authorizationHeader);

        return optionalUserDto.get();


    }

}
