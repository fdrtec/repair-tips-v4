package com.api.repairtips.domain.model.dto;

import java.io.Serializable;
import java.util.UUID;

// import org.hibernate.validator.constraints.Range;

// import org.hibernate.validator.constraints.br.CPF;

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
    
    // @CPF
    // private String cpf;

    // @Range(min = 10, max = 20)
    // private Integer limite;
    
    // private LocalDateTime createdDate;
    
    // private LocalDateTime lastModifiedDate;    
    
    // @NotEmpty
    // @DecimalMin("0")
    // @PositiveOrZero
    // private BigDecimal taxaFrete;
}
