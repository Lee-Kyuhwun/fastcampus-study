package dev.be.async.service;


import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AsyncService {

    private final EmailService emailService;
    public void asyncCall_1(){
        System.out.println("asyncCall_1 : {}" + Thread.currentThread().getName());
        emailService.sendEmail();
        emailService.sendEmailWithCustomThreadPool();
    }

    /**
     * 2,3번 처럼 하면 비동기 처리가 안된다.
     * */

    public void asyncCall_2(){ // 인스턴스 선언 후 비동기처리 되는지 확인
        System.out.println("asyncCall_2 : {}" + Thread.currentThread().getName());
        EmailService emailService = new EmailService();
        emailService.sendEmail();
        emailService.sendEmailWithCustomThreadPool();
    }

    public void asyncCall_3(){ // 내부 메서드 비동기처리 되는지 확인
        System.out.println("asyncCall_3 : {}" + Thread.currentThread().getName());
        sendemail();
    }

    @Async
    public void sendemail(){
        System.out.println("sendemail : {}" + Thread.currentThread().getName());
    }

}
