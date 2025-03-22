package com.fastcampus.crash.exception;

import org.springframework.http.HttpStatus;

public class ClientErrorException extends RuntimeException{

    private final HttpStatus status;

    public ClientErrorException(HttpStatus status,String message) {
        super(message); // 부모 클래스의 생성자 호출
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
