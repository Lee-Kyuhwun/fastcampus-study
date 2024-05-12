package dev.be.feign.feign.config;


import dev.be.feign.feign.decoder.DemoFeignErrorDecoder;
import dev.be.feign.feign.interceptor.DemoFeignInterCeptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoFeignConfig {

    @Bean
    public DemoFeignInterCeptor feignInterCeptor() {
        return DemoFeignInterCeptor.of(); // of는 static 메소드로 객체를 생성한다.
    }

    @Bean
    public DemoFeignErrorDecoder demoFeignErrorDecoder() {
        return new DemoFeignErrorDecoder();
    }

}
