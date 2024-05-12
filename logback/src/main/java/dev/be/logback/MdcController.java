package dev.be.logback;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MdcController {


    // 멀티쓰레드 환경에서 로그를 남길때 MDC를 사용하면 각 쓰레드별로 로그를 남길 수 있다.
    @GetMapping("/mdc")
    public String mdc() {
        MDC.put("job", "dev");
        log.trace("log -> trace");
        log.debug("log -> debug");
        log.info("log -> info");
        log.warn("log -> warn");
        log.error("log -> error");
        MDC.clear();
        return "Check the logs";
    }
}
