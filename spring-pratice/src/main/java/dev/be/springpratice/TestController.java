package dev.be.springpratice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    @Qualifier("testService")
    private  Service testService;


   @GetMapping("/test")
    public String test() {
         return testService.getTest();
    }

}
