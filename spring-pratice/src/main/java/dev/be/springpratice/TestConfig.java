package dev.be.springpratice;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public TestService testService() {
        return new TestService();
    }
}
