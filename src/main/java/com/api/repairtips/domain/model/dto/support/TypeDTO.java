package com.api.repairtips.domain.model.dto.support;

import com.api.repairtips.domain.model.dto.BaseDTO;

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