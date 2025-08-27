package com.fastcampus.crash.error.registration;

import com.fastcampus.crash.exception.ClientErrorException;
import com.fastcampus.crash.model.entity.UserEntity;
import org.springframework.http.HttpStatus;

public class RegistrationNotFoundException extends ClientErrorException {
    public RegistrationNotFoundException() {
        super(HttpStatus.NOT_FOUND, "SessionSpeaker not found.");
    }

    public RegistrationNotFoundException(Long registrationId, UserEntity currentUser) {
        super(HttpStatus.NOT_FOUND, " Registration with registrationId " + registrationId + " for user " + currentUser.getUsername() + " not found.");
    }
}