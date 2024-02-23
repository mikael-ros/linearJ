package com.embracket.linearJ.util;

public class WrongDimensionException extends Exception{
    public WrongDimensionException(){
        super();
    }
    public WrongDimensionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    public WrongDimensionException(String message, Throwable cause) {
        super(message, cause);
    }
    public WrongDimensionException(String message) {
        super(message);
    }
}
