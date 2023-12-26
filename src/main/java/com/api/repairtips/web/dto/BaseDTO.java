package com.api.repairtips.web.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;    
    private Long id;
}