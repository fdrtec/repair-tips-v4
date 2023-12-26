package com.api.repairtips.web.dto.support;

import java.util.List;

import com.api.repairtips.web.dto.BaseDTO;

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

    @NotNull
    private Boolean active;

}
