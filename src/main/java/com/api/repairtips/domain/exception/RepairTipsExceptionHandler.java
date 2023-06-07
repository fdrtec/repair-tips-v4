package com.api.repairtips.domain.exception;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RepairTipsExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)    
    @ExceptionHandler(NoSuchElementException.class)
    public ApiError handleNoSuchElementException( NoSuchElementException exception) {
        return buildExceptionResponse(
            HttpStatus.NOT_FOUND,
            exception.getMessage(),
            Collections.singletonList(exception.getClass().getName()));
    }

    // @ExceptionHandler(EntityNotFoundException.class)
    // public ResponseEntity<Object> handleEntityNotFoundException( EntityNotFoundException exception) {
    //     return buildResponseEntity(
    //         HttpStatus.NOT_FOUND,
    //         exception.getMessage(),
    //         Collections.singletonList(exception.getMessage()));
    // }

    // @ExceptionHandler(EntityExistsException.class)
    // public ResponseEntity<Object> handleEntityExistsException( EntityExistsException exception) {
    //     return buildResponseEntity(
    //         HttpStatus.CONFLICT,
    //         exception.getMessage(),
    //         Collections.singletonList(exception.getMessage()));
    // }

    private ApiError buildExceptionResponse( HttpStatus status, String message, List<String> errors){
        return ApiError.builder()        
        .timestamp(LocalDateTime.now())
        .status(status.value())
        .message(message)
        .errors(errors)
        .build();                
    }
    
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessException exception) {
        return ResponseEntity.status(500).body(exception);
        // else if(exception instanceof EntityExistsException){
            // super.handleExceptionInternal(ex, apiError, headers, status, request)
        // }
    }
}

