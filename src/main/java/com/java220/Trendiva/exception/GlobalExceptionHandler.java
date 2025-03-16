package com.java220.Trendiva.exception;

import com.java220.Trendiva.exception.custom.CategoryException;
import com.java220.Trendiva.exception.custom.MyUserException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(CategoryException.class)
    public ExceptionMessage CategoryExceptionHandler(CategoryException e){

        ExceptionMessage exceptionMessage= new ExceptionMessage();
        exceptionMessage.setCode(6001);
        exceptionMessage.setMessage(e.getMessage());

        return exceptionMessage;
    }


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
