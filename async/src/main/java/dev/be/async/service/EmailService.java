package dev.be.async.service;


import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    @Async("defaultTaskExecutor")
    public void sendEmail() {
        System.out.println("EmailService.sendEmail : {}" + Thread.currentThread().getName());
    }


    @Async("messagingTaskExecutor")
    public void sendEmailWithCustomThreadPool() {
        System.out.println("messagingTaskExecutor : {}" + Thread.currentThread().getName());
    }
}
