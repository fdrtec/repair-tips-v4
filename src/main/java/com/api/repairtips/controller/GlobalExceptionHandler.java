package com.api.repairtips.controller;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.log4j.Log4j2;

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
