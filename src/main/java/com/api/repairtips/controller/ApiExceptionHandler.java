package com.api.repairtips.controller;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.repairtips.domain.exception.ApiError;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    // @ResponseStatus(BAD_REQUEST)
    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public ApiError handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
    //     List<String> errors = ex.getBindingResult().getFieldErrors()
    //             .stream().map(FieldError::getDefaultMessage)
    //             .collect(Collectors.toList());

    //     log.info(request.getContextPath());

    //     log.error("MethodArgumentNotValidException: ", errors);

    //     return null;
    // }

    
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public ProblemDetail handleNoSuchElementException(Exception ex) {               
        logger.error(ExceptionUtils.getStackTrace(ex).substring(0, 500));        
        return buildProblemDetail(NOT_FOUND, ex);        
    }

    private ProblemDetail buildProblemDetail(HttpStatus status, Exception ex){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status, ex.getLocalizedMessage());        
        problemDetail.setType(URI.create(ex.getClass().getName()));
        return problemDetail; 
    }

    // @ExceptionHandler(Exception.class)
    // @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    // public ErrorMessage globalExceptionHandler(Exception ex, WebRequest request) {
    //     ErrorMessage message = new ErrorMessage(
    //             HttpStatus.INTERNAL_SERVER_ERROR.value(),
    //             LocalDateTime.now(),
    //             ex.toString(),
    //             request.getDescription(false));

    //     return message;
    // }

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

    private ApiError buildExceptionResponse(HttpStatus status, Exception ex) {
        // BindingResult bindingResult = ex.getBindingResult();

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
