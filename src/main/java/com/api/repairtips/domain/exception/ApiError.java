package com.api.repairtips.domain.exception;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;

@JsonInclude(Include.NON_NULL)
@Builder
@Getter
public class ApiError {
    
    private Integer code;

    private String status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy hh:mm")
    private LocalDateTime timestamp;

    private String message;

    private List<String> errors;
}
//Algaworks
//private Integer status
//private String type
//private String title
//private String detail
