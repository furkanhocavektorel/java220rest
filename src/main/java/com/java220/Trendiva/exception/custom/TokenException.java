package com.java220.Trendiva.exception.custom;

public class TokenException extends RuntimeException{

    public int code;
    public TokenException(String message,int code) {
        super(message);
        this.code=code;
    }

}
