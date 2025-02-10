package dev.be.studyspring.resttemplate.config;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Configuration // 스프링 설정 클래스
public class RestConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.of(1, ChronoUnit.SECONDS)) // 1초 지나도 응답이 없으면 에러
                .setReadTimeout(Duration.of(1, ChronoUnit.SECONDS))// 5초 지나도 응답이 없으면 에러
                .build();// 1초
    }
}
