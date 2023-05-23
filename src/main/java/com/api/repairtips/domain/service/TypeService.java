package com.api.repairtips.domain.service;

import java.lang.annotation.RetentionPolicy;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import com.api.repairtips.domain.exception.BusinessException;
import com.api.repairtips.domain.model.assembler.ModelAssembler;
import com.api.repairtips.domain.model.dto.TypeDTO;
import com.api.repairtips.domain.model.entity.Type;
import com.api.repairtips.domain.model.enumeration.StateResponseEnum;
import com.api.repairtips.domain.repository.TypeRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class TypeService extends ModelAssembler<TypeDTO, Type> {

    @Autowired
    private TypeRepository repository;

    public TypeDTO getById(UUID id) {
        Type type = repository.findById(id)
        .orElseThrow(() -> new NotFoundException("ENTITY_NOT_FOUND"));
        return this.toDTO(type);        
    }
    @Transactional
    public TypeDTO create(TypeDTO typeDTO){
        verifyIfExists(typeDTO.getName());
        Type type = repository.saveAndFlush(this.toEntity(typeDTO));
        return this.toDTO(type);
    }

    private void verifyIfExists(String typeName) {        
        repository.findByName(typeName)
        .ifPresent((type) -> { 
            throw new BusinessException(new EntityExistsException("ENTITY_ALREADY_EXISTS"));
        });
    }

    @Transactional
    public void deleteById(UUID id){         
            existsTypeById(id);           
            repository.deleteById(id);
            // tratamento para descarregar o banco dentro do try - algaworks
            repository.flush();       
    }

    @Transactional
    public void update(TypeDTO typeDTO) {
        existsTypeById(typeDTO.getId());
        repository.saveAndFlush(this.toEntity(typeDTO));        
    }
    
    private Type existsTypeById(UUID id){
        return repository.findById(id)
        .orElseThrow(() -> new BusinessException(
            new NotFoundException("ENTITY_NOT_FOUND")
        ));
    }
}
