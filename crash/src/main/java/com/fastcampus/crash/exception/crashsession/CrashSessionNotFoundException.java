package com.fastcampus.crash.exception.crashsession;

import com.fastcampus.crash.exception.ClientErrorException;
import org.springframework.http.HttpStatus;

public class CrashSessionNotFoundException  extends ClientErrorException {

    public CrashSessionNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Crash Session Not Found");
    }

    public CrashSessionNotFoundException(Long sessionId) {
        super(HttpStatus.NOT_FOUND, "Crash Session Not Found: " + sessionId);
    }
}
