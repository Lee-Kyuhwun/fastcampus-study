package dev.be.moduleapi.exception;


import dev.be.modulecommon.enums.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class CustomException extends RuntimeException{

    private String resultCode;
    private String resultMessage;

    public CustomException(CodeEnum codeEnum){
        super(codeEnum.getMessage()); // 부모 클래스인 RuntimeException에 메시지를 넘겨줌
        setResultCode(codeEnum.getCode());
        setResultMessage(codeEnum.getMessage());
    }



}
