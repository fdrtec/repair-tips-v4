package com.api.repairtips.domain.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class TypeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID id;

    @NotBlank
    @Size(max = 255)
    private String name;    
    
    // private LocalDateTime createdDate;
    
    // private LocalDateTime lastModifiedDate;   
}
