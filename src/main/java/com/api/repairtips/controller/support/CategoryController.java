package com.api.repairtips.controller.support;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.repairtips.controller.docs.ControllerDocs;
import com.api.repairtips.domain.model.dto.support.CategoryDTO;
import com.api.repairtips.domain.model.dto.TypeDTO;
import com.api.repairtips.domain.service.support.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController implements ControllerDocs<CategoryDTO>{

    private final CategoryService service;

    @Override
    public CategoryDTO create(@Valid CategoryDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public TypeDTO findById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Page<CategoryDTO> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @Override
    public void deleteById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public CategoryDTO update(@Valid CategoryDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
