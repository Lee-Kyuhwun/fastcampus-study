package dev.be.moduleapi.exceptionhandler;


import dev.be.moduleapi.exception.CustomException;
import dev.be.moduleapi.response.CommonResponse;
import dev.be.modulecommon.enums.CodeEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // RestController에서 발생하는 예외를 처리하기 위한 어노테이션
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public CommonResponse handleException(CustomException e){
        return CommonResponse.builder()
                .returnCode(e.getResultCode())
                .returnMessage(e.getResultMessage())
                .build();
    }

    @ExceptionHandler(Exception.class)
    public CommonResponse handleException(Exception e){
        return CommonResponse.builder()
                .returnCode(CodeEnum.UNKNOWN_ERROR.getCode())
                .returnMessage(e.getMessage())
                .build();
    }
}
