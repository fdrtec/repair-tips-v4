package com.api.repairtips.domain.model.dto.support;

import java.util.List;

import com.api.repairtips.domain.model.dto.BaseDTO;
import com.api.repairtips.domain.model.entity.Category;
import com.fasterxml.jackson.annotation.JsonInclude;

// import org.hibernate.validator.constraints.Range;

// import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class TypeDTO extends BaseDTO {

    @NotBlank(message = "name is required")
    @Size(max = 150)
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Category> categories;

    // @CPF
    // private String cpf;

    // @Range(min = 10, max = 20)
    // private Integer limite;

    // private LocalDateTime createdDate;

    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    // private LocalDateTime lastModifiedDate;

    // @NotEmpty
    // @DecimalMin("0")
    // @PositiveOrZero
    // private BigDecimal taxaFrete;
}
