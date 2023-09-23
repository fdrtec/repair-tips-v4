package com.api.repairtips.domain.model.dto;

import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    
    private UUID id;

}
