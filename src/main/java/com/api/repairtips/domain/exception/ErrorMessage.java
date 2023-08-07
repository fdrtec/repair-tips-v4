package com.api.repairtips.domain.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorMessage {    
    private int statusCode;
    private LocalDateTime timestamp;
    private String message;
    private String description;
}
