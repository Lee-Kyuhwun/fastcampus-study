package com.fastcampus.crash.error.user;

import com.fastcampus.crash.exception.ClientErrorException;
import org.springframework.http.HttpStatus;


public class UserAlreadyException extends ClientErrorException
{
    public UserAlreadyException(){
        super(HttpStatus.NOT_FOUND, "User Not Found");
    }

    public UserAlreadyException(String username){
        super(HttpStatus.NOT_FOUND, "User Not Found: " + username);
    }


}
