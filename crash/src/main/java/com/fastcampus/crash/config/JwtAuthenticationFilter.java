package com.fastcampus.crash.config;


import com.fastcampus.crash.service.JwtService;
import com.fastcampus.crash.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserService userService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        // JWT 인증 로직
        // 헤더에서 JWT 토큰을 받아온다.
        // 토큰이 유효한지 확인한다.
        // 토큰이 유효하다면 토큰에서 유저 정보를 받아온다.
        // 유저 정보를 SecurityContext에 저장한다.
        String BEARER_PREFIX = "Bearer ";
        var authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        var securityContext = SecurityContextHolder.getContext();

        if(        !ObjectUtils.isEmpty(authorization) && authorization.startsWith(BEARER_PREFIX) && // 헤더에 Authorization이 있고 Bearer로 시작하면
                securityContext.getAuthentication() == null){

            var accessToken = authorization.substring(BEARER_PREFIX.length()); // Bearer 다음의 토큰만 추출
            String username = jwtService.getUsername(accessToken);

            UserDetails userDetails = userService.loadUserByUsername(username);// username으로 사용자 정보를 가져옴

            var authenticationToken =
            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); // request 정보를 저장
            securityContext.setAuthentication(authenticationToken);
            SecurityContextHolder.setContext(securityContext);
        }
        filterChain.doFilter(request,response); // 다음 필터로 넘어가기
    }
}
