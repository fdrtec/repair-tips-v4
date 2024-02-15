package com.api.repairtips.domain.service.support;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.repairtips.domain.model.conversor.ModelConversor;
import com.api.repairtips.domain.model.entity.Category;
import com.api.repairtips.domain.repository.CategoryRepository;
import com.api.repairtips.domain.service.interfaces.IcrudService;
import com.api.repairtips.web.dto.support.CategoryDTO;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService implements IcrudService<CategoryDTO>, ModelConversor<CategoryDTO, Category> {

    private final CategoryRepository repository;     

    @Transactional 
    public Page<CategoryDTO> findAll(Pageable pageable) {
        
        if(Objects.nonNull(pageable)){
            Page<Category> result = repository.findAll(pageable);
            return this.toCollectionDTO(result, pageable);
        }
        throw new  IllegalArgumentException("Parâmetro inválido!");
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
