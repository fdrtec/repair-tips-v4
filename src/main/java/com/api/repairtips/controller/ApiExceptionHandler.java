package com.api.repairtips.controller;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.repairtips.domain.exception.ApiError;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public ApiError handleNoSuchElementException(NoSuchElementException exception) {
        // Throwable rootCause = ExceptionUtils.getRootCause(exception);
        return buildExceptionResponse(NOT_FOUND, exception.getMessage(),
                Collections.singletonList(exception.getClass().getName()));
    }

    // para fazer testes com atributos com @Valid - rever algaworks 9.11
    // messages.properties
    // @ResponseStatus(BAD_REQUEST)
    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public ApiError handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
    //     BindingResult bindingResult = exception.getBindingResult();

    //     return buildExceptionResponse(
    //             BAD_REQUEST,
    //             exception.getMessage(),
    //             bindingResult.getAllErrors().stream()
    //                     .map(objectError -> objectError.getDefaultMessage())
    //                     .toList());
    // }

    //Exceptions para testar com delete
    //EmptyResultDataAccessException
    //DataIntegrityVioletionException 

    // Para @Valid do beanValidation erro 400
    // MethodArgumentNotValidException

    // public ResponseEntity<Object> handleEntityNotFoundException(
    // EntityNotFoundException exception) {
    // return buildResponseEntity(
    // HttpStatus.NOT_FOUND,
    // exception.getMessage(),
    // Collections.singletonList(exception.getMessage()));
    // }

    // @ExceptionHandler(EntityExistsException.class)
    // public ResponseEntity<Object> handleEntityExistsException(
    // EntityExistsException exception) {
    // return buildResponseEntity(
    // HttpStatus.CONFLICT,
    // exception.getMessage(),
    // Collections.singletonList(exception.getMessage()));
    // }

    private ApiError buildExceptionResponse(HttpStatus status, String message, List<String> errors) {
        return ApiError.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .message(message)
                .errors(errors)
                .build();
    }

    // @ExceptionHandler(BusinessException.class)
    // public ResponseEntity<Object> handleBusinessException(BusinessException
    // exception) {
    // return ResponseEntity.status(500).body(exception);
    // // else if(exception instanceof EntityExistsException){
    // // super.handleExceptionInternal(ex, apiError, headers, status, request)
    // // }
    // }
}
