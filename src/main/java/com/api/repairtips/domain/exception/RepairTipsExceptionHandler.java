package com.api.repairtips.domain.exception;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class RepairTipsExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException( EntityNotFoundException exception) {
        return buildResponseEntity(
            HttpStatus.NOT_FOUND,
            exception.getMessage(),
            Collections.singletonList(exception.getMessage()));
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<Object> handleEntityExistsException( EntityExistsException exception) {
        return buildResponseEntity(
            HttpStatus.CONFLICT,
            exception.getMessage(),
            Collections.singletonList(exception.getMessage()));
    }

    private ResponseEntity<Object> buildResponseEntity(HttpStatus httpStatus, String message, List<String> errors){
        ApiError apiError = ApiError.builder()
        .code(httpStatus.value())
        .status(httpStatus.getReasonPhrase())
        .message(message)
        .errors(errors)
        .timestamp(LocalDateTime.now())
        .build();

        return ResponseEntity.status(httpStatus).body(apiError);        
    }
    
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessException exception) {
        return ResponseEntity.status(500).body(exception);
        // else if(exception instanceof EntityExistsException){
            // super.handleExceptionInternal(ex, apiError, headers, status, request)
        // }
    }
}

