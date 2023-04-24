package com.api.repairtips.domain.exception;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
    
    private Integer code;

    private String status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy hh:mm")
    private LocalDateTime timestamp;

    private String message;

    private List<String> errors;
}
