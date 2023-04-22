package com.api.repairtips.domain.model.dto;

import java.io.Serializable;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
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
    private String name;    
}
