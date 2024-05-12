package dev.be.feign.feign.client;


import dev.be.feign.feign.common.dto.BaseResponseInfo;
import dev.be.feign.feign.config.DemoFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "demo-client", // name of the client
        url = "${feign.url.prefix}", // url prefix
        configuration = DemoFeignConfig.class // configuration class
)
public interface DemoFeignClient { // feign은 선언형이므로 인터페이스로 선언
    // 선언형이란 사용자가 호출할 메소드를 선언만 하고 실제 구현은 feign이 대신 해주는 것을 의미

    @GetMapping("/get") // prefix + /get
    ResponseEntity<BaseResponseInfo> callGet(@RequestHeader("CustomHeaderName") String customHeader,
                                             @RequestParam("name") String name,
                                             @RequestParam("age") Long age);


}
