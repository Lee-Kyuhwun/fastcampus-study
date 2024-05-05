package dev.be.moduleapi; // spring bean 컴포넌트 스캔을 위해 패키지 이동

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"dev.be.moduleapi", "dev.be.modulecommon"}) // scanBasePackages 추가
@EntityScan("dev.be.modulecommon.domain") // EntityScan 추가
@EnableJpaRepositories("dev.be.modulecommon.repository") // EnableJpaRepositories 추가
public class ModuleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleApiApplication.class, args);
    }

}
