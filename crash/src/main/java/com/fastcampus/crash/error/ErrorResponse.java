package com.fastcampus.crash.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;


@JsonInclude(JsonInclude.Include.NON_EMPTY) // null 값은 출력하지 않음
public record ErrorResponse(HttpStatus status, Object message) {


}
