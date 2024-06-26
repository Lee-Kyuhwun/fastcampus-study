package dev.be.feign.service;


import dev.be.feign.feign.client.DemoFeignClient;
import dev.be.feign.feign.common.dto.BaseRequesetInfo;
import dev.be.feign.feign.common.dto.BaseResponseInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService{

    private final DemoFeignClient demoFeignClient;
    public String get() {
        ResponseEntity<BaseResponseInfo> response = demoFeignClient.callGet("CustomHeader", "CustomName", 1L);
        System.out.println("Name = " + response.getBody().getName());
        System.out.println("Age = " + response.getBody().getAge());
        System.out.println("Header = " + response.getBody().getHeader());


        return "Hello from service";
    }

    public String post() {

        BaseRequesetInfo baseRequesetInfo = BaseRequesetInfo.builder()
                .name("CustomName")
                .age(1L)
                .build();

        ResponseEntity<BaseResponseInfo> response = demoFeignClient.callPost("CustomHeader", baseRequesetInfo);
        System.out.println("Name = " + response.getBody().getName());
        System.out.println("Age = " + response.getBody().getAge());
        System.out.println("Header = " + response.getBody().getHeader());


        return "Hello from service";
    }


    public String errorDecoder() {
        demoFeignClient.callErrorDecoder();
        return "error";
    }
}
