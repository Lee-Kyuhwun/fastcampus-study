package dev.be.modulecommon.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public enum CodeEnum {
    SUCCESS("0000", "Success"),
    UNKNOWN_ERROR("9999", "Unknown error"),;


    private String code;
    private String message;
}
