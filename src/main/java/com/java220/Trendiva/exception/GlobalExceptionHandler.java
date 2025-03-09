package com.java220.Trendiva.exception;

import com.java220.Trendiva.exception.custom.MyUserException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MyUserException.class)
    public ExceptionMessage myUserExceptionHandler(MyUserException mue){

        ExceptionMessage exceptionMessage = new ExceptionMessage();
        exceptionMessage.setCode(4001);
        exceptionMessage.setMessage(mue.getMessage());

        return exceptionMessage;
    }

    @ExceptionHandler(RuntimeException.class)
    public ExceptionMessage MyRuntimeException(RuntimeException ex){

        ExceptionMessage exceptionMessage= new ExceptionMessage();
        exceptionMessage.setCode(5007);
        exceptionMessage.setMessage(ex.getMessage());

        return exceptionMessage;
    }

}
