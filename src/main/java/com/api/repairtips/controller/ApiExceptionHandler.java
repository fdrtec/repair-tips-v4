package com.api.repairtips.controller;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.repairtips.domain.exception.ApiError;
import com.api.repairtips.domain.exception.ErrorMessage;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiError handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
            .stream().map(FieldError::getDefaultMessage)
            .collect(Collectors.toList());
        
            log.info(request.getContextPath());
        
        log.error("MethodArgumentNotValidException: ", errors);
        
        return null;
    }
    
    // Pai das exceptions do jpa
    // javax.persistence.PersistenceException
    // quando estiver encapsulado por um optional lança só
    // NoSuchElementException(.get)
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public ApiError handleNoSuchElementException(BindException ex) {
        // Throwable rootCause = ExceptionUtils.getRootCause(ex);
        logger.error("NoSuchElementException: ", ex);
        
        //TODO: criar enum para tipar os tipos de erros
        // ApiErrorType apiErrorType = ApiErrorType.NOT_FOUND;
        
        // BindingResult bindingResult = exception.getBindingResult();

        return buildExceptionResponse(NOT_FOUND, ex);
    }



    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now(),
                ex.toString(),
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

    private ApiError buildExceptionResponse(HttpStatus status, BindException ex) {
         BindingResult bindingResult = ex.getBindingResult();

        return ApiError.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .message(ex.toString())
                .error(ex.getLocalizedMessage())
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
