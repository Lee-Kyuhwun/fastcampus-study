package dev.be.feign.feign.common.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)// 이 필드가 null이면 json으로 변환하지 않는다.
public class BaseResponseInfo {

    private String name;
    private Long age;
    private String header;
}
