package com.api.repairtips.domain.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(Exception originalException) {
        super(originalException);
    }    
}
