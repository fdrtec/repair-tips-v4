package com.api.repairtips.domain.model.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(Exception originalException) {
        super(originalException);
    }
    
    public BusinessException(String message) {
        super(message);
    }  
}
