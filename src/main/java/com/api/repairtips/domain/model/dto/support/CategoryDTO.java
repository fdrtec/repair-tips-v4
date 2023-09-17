package com.api.repairtips.domain.model.dto.support;

import java.util.UUID;

import com.api.repairtips.domain.model.dto.BaseDTO;
import com.api.repairtips.domain.model.dto.TypeDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO extends BaseDTO {    

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Type is required")
    private TypeDTO type;

    @NotNull
    private Boolean active;

}
