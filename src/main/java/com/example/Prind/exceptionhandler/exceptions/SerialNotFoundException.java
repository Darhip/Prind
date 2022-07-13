package com.example.Prind.exceptionhandler.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK)
public class SerialNotFoundException extends Exception {
    public SerialNotFoundException(String message) {
        super(message);
    }

}