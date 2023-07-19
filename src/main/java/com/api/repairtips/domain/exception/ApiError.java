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
        
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm")
    private LocalDateTime timestamp;
    
    private Integer status;   
    
    private String message;

    private List<?> errors;
}
//Algaworks: Padrão RFC 7807 - Problem detail for HTTP API 
//private Integer status
//private String type
//private String title
//private String detail
//private String instance
