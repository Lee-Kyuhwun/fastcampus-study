package dev.be.async.controller;


import dev.be.async.service.AsyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AsyncController {

    private final AsyncService asyncService;


    @GetMapping("/1")
    public String async1() {
        asyncService.asyncCall_1();
        return "async1";
    }
    @GetMapping("/2")
    public String async2() {
        asyncService.asyncCall_2();
        return "async1";
    }
    @GetMapping("/3")
    public String async3() {
        asyncService.asyncCall_3();
        return "async1";
    }
}
