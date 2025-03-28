package com.fastcampus.crash.exception;


import com.fastcampus.crash.error.ClientErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientErrorException.class)
    public ResponseEntity<ClientErrorResponse> handleClientErrorException(ClientErrorException e) {
        return new ResponseEntity<>(
                new ClientErrorResponse(e.getStatus(), e.getMessage()),
                e.getStatus()
                );
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ClientErrorResponse> handleClientErrorException(RuntimeException e) {
        return ResponseEntity.internalServerError().build();
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ClientErrorResponse> handleClientErrorException(Exception e) {
        return ResponseEntity.internalServerError().build();
    }



}
