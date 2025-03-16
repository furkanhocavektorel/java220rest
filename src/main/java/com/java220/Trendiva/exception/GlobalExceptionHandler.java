package com.java220.Trendiva.exception;

import com.java220.Trendiva.exception.custom.CategoryException;
import com.java220.Trendiva.exception.custom.MyUserException;
import com.java220.Trendiva.exception.custom.TokenException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(TokenException.class)
    public ExceptionMessage tokenExceptionHandler(TokenException e){
        ExceptionMessage exceptionMessage= new ExceptionMessage();
        exceptionMessage.setCode(e.code);
        exceptionMessage.setMessage(e.getMessage());

        return exceptionMessage;
    }


    @ExceptionHandler(CategoryException.class)
    public ExceptionMessage categoryExceptionHandler(CategoryException e){

        ExceptionMessage exceptionMessage= new ExceptionMessage();
        exceptionMessage.setCode(e.code);
        exceptionMessage.setMessage(e.getMessage());

        return exceptionMessage;
    }


    @ExceptionHandler(MyUserException.class)
    public ExceptionMessage myUserExceptionHandler(MyUserException mue){

        ExceptionMessage exceptionMessage = new ExceptionMessage();
        exceptionMessage.setCode(mue.code);
        exceptionMessage.setMessage(mue.getMessage());

        return exceptionMessage;
    }

    @ExceptionHandler(RuntimeException.class)
    public ExceptionMessage MyRuntimeException(RuntimeException ex){

        ExceptionMessage exceptionMessage= new ExceptionMessage();
        exceptionMessage.setCode(1000);
        exceptionMessage.setMessage(ex.getMessage());

        return exceptionMessage;
    }

}
