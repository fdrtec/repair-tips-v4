package com.api.repairtips.web.controller;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.net.URI;
import java.util.NoSuchElementException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.log4j.Log4j2;

//INFO: Referencia de estudo(ExceptionHandler)
//Revisar error array
//aula 54 https://www.udemy.com/course/spring-boot-expert/learn/lecture/18172114#overview

@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ MethodArgumentNotValidException.class })
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        // BindingResult br = ex.getBindingResult();
        // List<String> validatorErrors = br.getAllErrors()
        //         .stream().map(e -> e.getDefaultMessage())
        //         .collect(Collectors.toList());
        
        log.error(ExceptionUtils.getStackTrace(ex).substring(0, 500));
        return buildProblemDetail(BAD_REQUEST, ex);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ProblemDetail handleNoSuchElementException(NoSuchElementException ex) {
        log.error(ExceptionUtils.getStackTrace(ex).substring(0, 500));
        return buildProblemDetail(NOT_FOUND, ex);
    }

    private ProblemDetail buildProblemDetail(HttpStatus status, Exception ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status, ex.getLocalizedMessage());
        problemDetail.setType(URI.create(ex.getClass().getName()));
        return problemDetail;
    }

}
