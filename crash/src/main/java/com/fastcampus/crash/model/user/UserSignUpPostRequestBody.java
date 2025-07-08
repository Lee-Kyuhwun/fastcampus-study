package com.fastcampus.crash.model.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;


public record UserSignUpPostRequestBody(
        @NotEmpty String username,
        @NotEmpty String password,
        @NotEmpty String name,
        @NotEmpty @Email String email

) {

}
