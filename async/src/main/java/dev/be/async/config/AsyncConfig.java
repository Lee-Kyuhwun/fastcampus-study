package dev.be.async.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync // 이 어노테이션을 붙여야 스프링이 비동기 처리를 위한 프록시 객체를 생성한다.
public class AsyncConfig {
}
