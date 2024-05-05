package dev.be.moduleapi; // spring bean 컴포넌트 스캔을 위해 패키지 이동

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"dev.be.moduleapi", "dev.be.modulecommon"}) // scanBasePackages 추가
public class ModuleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleApiApplication.class, args);
    }

}
