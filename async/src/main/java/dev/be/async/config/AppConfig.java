package dev.be.async.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration // 이 어노테이션을 붙여야 스프링이 이 클래스를 설정 클래스로 인식한다.
public class AppConfig {

    @Bean(name ="defaultTaskExecutor") // 이 어노테이션을 붙여야 스프링이 이 메서드가 반환하는 객체를 빈으로 등록한다.
    public ThreadPoolTaskExecutor defaultTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(200); // 기본 스레드 개수
        taskExecutor.setMaxPoolSize(300); // 최대 스레드 개수
        return taskExecutor;
    }


    @Bean(name ="messagingTaskExecutor", destroyMethod = "shutdown") // destroyMethod 속성을 사용하면 빈이 소멸될 때 호출할 메서드를 지정할 수 있다.
    public ThreadPoolTaskExecutor messagingTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(10); // 기본 스레드 개수
        taskExecutor.setMaxPoolSize(100); // 최대 스레드 개수
        return taskExecutor;
    }
}
