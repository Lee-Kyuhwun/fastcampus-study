package com.fastcampus.crash.error.user;

import com.fastcampus.crash.exception.ClientErrorException;
import org.springframework.http.HttpStatus;


public class UserNotFoundException extends ClientErrorException
{
    public UserNotFoundException(){
        super(HttpStatus.NOT_FOUND, "User Not Found");
    }

    public UserNotFoundException(String username){
        super(HttpStatus.NOT_FOUND, "User Not Found: " + username);
    }


}
