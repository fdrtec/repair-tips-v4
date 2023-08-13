package com.api.repairtips.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.repairtips.domain.model.assembler.ModelAssembler;
import com.api.repairtips.domain.model.dto.TypeDTO;
import com.api.repairtips.domain.model.entity.Type;
import com.api.repairtips.domain.repository.TypeRepository;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TypeService extends ModelAssembler<TypeDTO, Type> {

    private final TypeRepository repository;

    @Transactional(readOnly = true)
    public List<TypeDTO> findAll() {
        // exemplo de programação defensiva
        // if(list.isEmpty()){
        // throw new IllegalStateException("descrição qualquer coisa ilegal")
        // }
        return this.toCollectionDTO(repository.findAll());
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
    public void update(TypeDTO dto) {    
        repository.findById(dto.getId()).get();
        repository.saveAndFlush(this.toEntity(dto));                
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
