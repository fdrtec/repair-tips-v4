package com.api.repairtips.domain.service.support;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.repairtips.domain.model.assembler.ModelAssembler;
import com.api.repairtips.domain.model.entity.Category;
import com.api.repairtips.domain.repository.CategoryRepository;
import com.api.repairtips.domain.service.interfaces.IcrudService;
import com.api.repairtips.web.dto.support.CategoryDTO;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService extends ModelAssembler<CategoryDTO, Category> implements IcrudService<CategoryDTO> {

    private final CategoryRepository repository;

    @Transactional 
    public Page<CategoryDTO> findAll(Pageable pageable) {
        return this.toCollectionDTO(repository.findAll(pageable), pageable);
    }

    @Override
    public CategoryDTO findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public CategoryDTO create(CategoryDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public CategoryDTO update(CategoryDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
