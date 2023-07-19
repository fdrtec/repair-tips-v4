package com.api.repairtips.controller;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.NoSuchElementException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.repairtips.domain.exception.ApiError;
import com.api.repairtips.domain.exception.ErrorMessage;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    // Pai das exceptions do jpa
    // javax.persistence.PersistenceException
    // quando estiver encapsulado por um optional lança só
    // NoSuchElementException(.get)
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public ApiError handleNoSuchElementException(NoSuchElementException exception) {
        Throwable rootCause = ExceptionUtils.getRootCause(exception);
        // BindingResult bindingResult = exception.getBindingResult();

        return buildExceptionResponse(NOT_FOUND, rootCause);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false));

        return message;
    }

    // erro de ambiguidade
    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // @ResponseStatus(BAD_REQUEST)
    // public ApiError
    // handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

    // return buildExceptionResponse(BAD_REQUEST, ex);
    // }

    // para fazer testes com atributos com @Valid - rever algaworks 9.11
    // messages.properties
    // @ResponseStatus(HttpStatus.BAD_REQUEST)
    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public ApiError
    // handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
    // BindingResult bindingResult = ex.getBindingResult();

    // return buildExceptionResponse(
    // HttpStatus.BAD_REQUEST,
    // bindingResult,
    // ex
    // );
    // // exception.getMessage(),
    // // bindingResult.getAllErrors().stream()
    // // .map(objectError -> objectError.getDefaultMessage())
    // // .toList());
    // }

    // Exceptions para testar com delete
    // EmptyResultDataAccessException
    // DataIntegrityVioletionException

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

    private ApiError buildExceptionResponse(HttpStatus status, Throwable ex) {
        // BindingResult bindingResult = ((BindException) ex).getBindingResult();

        return ApiError.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .message(ex.getMessage())
                .errors(Collections.singletonList(ex.getLocalizedMessage()))
                .build();
    }

    private ApiError buildExceptionResponse(HttpStatus status, BindingResult bindingResult, Throwable ex) {
        return ApiError.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .message(ex.getMessage())
                .errors(bindingResult.getAllErrors())
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
