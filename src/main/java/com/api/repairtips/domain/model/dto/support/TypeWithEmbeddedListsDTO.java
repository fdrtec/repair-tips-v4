package com.api.repairtips.domain.model.dto.support;

import java.util.ArrayList;
import java.util.List;

import com.api.repairtips.domain.model.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class TypeWithEmbeddedListsDTO extends TypeDTO {    

    // @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Category> categories = new ArrayList<>();    
}
