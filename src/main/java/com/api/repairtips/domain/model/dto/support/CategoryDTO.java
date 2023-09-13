package com.api.repairtips.domain.model.dto.support;

import java.util.UUID;

import com.api.repairtips.domain.model.dto.BaseDTO;
import com.api.repairtips.domain.model.dto.TypeDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO extends BaseDTO {

    private UUID id;

    private String name;

    private TypeDTO type;

    private Boolean active;

}
