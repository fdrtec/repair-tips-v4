package com.api.repairtips.domain.service.support;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.repairtips.domain.model.assembler.ModelAssembler;
import com.api.repairtips.domain.model.dto.TypeDTO;
import com.api.repairtips.domain.model.entity.Type;
import com.api.repairtips.domain.repository.TypeRepository;
import com.api.repairtips.domain.service.IcrudService;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TypeService extends ModelAssembler<TypeDTO, Type> implements IcrudService<TypeDTO> {

    private final TypeRepository repository;

    @Transactional(readOnly = true)
    public Page<TypeDTO> findAll(Pageable pageable) {        
        return this.toCollectionDTO(repository.findAll(pageable), pageable);
    }

    @Transactional
    public TypeDTO findById(UUID id) {
        return this.toDTO(repository.findById(id).get());        
    }

    @Transactional
    public TypeDTO create(TypeDTO dto) {
        hasConflict(dto);
        return this.toDTO(repository.saveAndFlush(this.toEntity(dto)));        
    }

    private void hasConflict(TypeDTO dto) {
        if (repository.findByName(dto.getName()).isPresent()) {
            new EntityExistsException("ENTITY_ALREADY_EXISTS");
        }
    }

    @Transactional
    public void delete(UUID id) {        
        repository.delete(repository.findById(id).get());        
        repository.flush();
    }
    
    @Transactional
    public TypeDTO update(TypeDTO dto) {    
        Type type = repository.findById(dto.getId()).get();
        BeanUtils.copyProperties(this.toEntity(dto), type, "id");
        return this.toDTO(repository.saveAndFlush(type));                
    }    

    //alternativa para filtro com example, isso seria via parametros via get :(
    public List<Type> filterFind(Type filter) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Type> example = Example.of(filter, matcher);

        return repository.findAll(example);

    }
}
