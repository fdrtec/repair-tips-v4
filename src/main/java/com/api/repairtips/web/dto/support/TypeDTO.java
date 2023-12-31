package com.api.repairtips.web.dto.support;

import java.util.List;

import com.api.repairtips.domain.model.entity.Category;
import com.api.repairtips.web.dto.BaseDTO;
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

}
