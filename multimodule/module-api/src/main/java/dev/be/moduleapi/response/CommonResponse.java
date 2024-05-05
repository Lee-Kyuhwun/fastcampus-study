package dev.be.moduleapi.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import dev.be.modulecommon.enums.CodeEnum;
import lombok.*;

@Getter
@Builder
@Setter
@JsonInclude(Include.NON_NULL) // 응답을 하더라고 info가 없을 수 있으므로 null인 경우 필드값에 외
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {
    private String returnCode;

    private String returnMessage;

    private T info;


    // codeEnum을 받아서 응답을 생성하는 생성자
    public CommonResponse(CodeEnum codeEnum) {
      setReturnCode(codeEnum.getCode());
        setReturnMessage(codeEnum.getMessage());
    }

    // info를 받아서 성공 응답을 생성하는 생성자
    public CommonResponse( T info) {
        setReturnCode(CodeEnum.SUCCESS.getCode());
        setReturnMessage(CodeEnum.SUCCESS.getMessage());
        setInfo(info);
    }

    public CommonResponse(CodeEnum codeEnum, T info) {
        setReturnCode(codeEnum.getCode());
        setReturnMessage(returnMessage);
        setInfo(info);
    }

}
