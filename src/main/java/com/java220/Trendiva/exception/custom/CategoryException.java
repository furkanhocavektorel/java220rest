package com.java220.Trendiva.exception.custom;

public class CategoryException extends RuntimeException{

    public int code;

    public CategoryException(String message,int code) {
        super(message);
        this.code = code;
    }
}
