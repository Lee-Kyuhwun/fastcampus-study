package com.fastcampus.crash.error.registration;

import com.fastcampus.crash.exception.ClientErrorException;
import com.fastcampus.crash.model.entity.UserEntity;
import org.springframework.http.HttpStatus;

public class RegistrationAlreadyExistsException extends ClientErrorException {
    public RegistrationAlreadyExistsException() {
        super(HttpStatus.CONFLICT, "SessionSpeaker not found.");
    }

    public RegistrationAlreadyExistsException(Long sessionId, UserEntity currentUser) {
        super(HttpStatus.CONFLICT, " Registration for sessionId " + sessionId + " for user " + currentUser.getUsername() + " already exists.");
    }
}