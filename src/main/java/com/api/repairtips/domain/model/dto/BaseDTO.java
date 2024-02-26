package com.api.repairtips.domain.model.dto;

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

    /** Anotações de sintaxes úteis
    
    @CPF
    private String cpf;

    @Range(min = 10, max = 20)
    private Integer limite;

    private LocalDateTime createdDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDateTime lastModifiedDate;

    @NotEmpty
    @DecimalMin("0")
    @PositiveOrZero
    private BigDecimal taxaFrete;
    
    */
}
