package com.api.repairtips.domain.service.support;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.repairtips.domain.model.assembler.ModelAssembler;
import com.api.repairtips.domain.model.dto.support.CategoryDTO;
import com.api.repairtips.domain.model.entity.Category;
import com.api.repairtips.domain.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService extends ModelAssembler<CategoryDTO, Category> {

    private final CategoryRepository repository;

    public Page<CategoryDTO> findAll(Pageable pageable) {
        return this.toCollectionDTO(repository.findAll(pageable), pageable);
    }
    
}
