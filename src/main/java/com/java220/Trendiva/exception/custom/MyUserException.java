package com.java220.Trendiva.exception.custom;

public class MyUserException extends RuntimeException {

    public int code;
    public MyUserException(String message , int code) {
        super(message);
        this.code=code;
    }
}
