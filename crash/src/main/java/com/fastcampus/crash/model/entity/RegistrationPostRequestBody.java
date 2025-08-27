package com.fastcampus.crash.model.entity;

import jakarta.validation.constraints.NotNull;

public record RegistrationPostRequestBody(
        @NotNull Long sessionId
        ) {}
