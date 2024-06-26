package dev.be.feign.controller;


import dev.be.feign.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {
    private final DemoService demoService;

    @GetMapping("/get")
    public String getController() {
        return demoService.get();
    }

    @PostMapping("/get")
    public String postController() {
        return demoService.post();
    }

    @GetMapping("/post")
    public String postController1() {
        return demoService.post();
    }


    @GetMapping("/error")
    public String errorDecoderController() {
        return demoService.errorDecoder();
    }

}
