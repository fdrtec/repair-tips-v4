package com.api.repairtips.domain.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.repairtips.domain.model.assembler.ModelAssembler;
import com.api.repairtips.domain.model.dto.TypeDTO;
import com.api.repairtips.domain.model.entity.Type;
import com.api.repairtips.domain.repository.TypeRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class TypeService extends ModelAssembler<TypeDTO, Type> {

    @Autowired
    private TypeRepository repository;

    public TypeDTO getById(UUID id) {
        return null;
    }

    @Transactional
    public TypeDTO create(TypeDTO typeDTO){
        verifyIfExists(typeDTO.getName());
        Type type = repository.save(this.toEntity(typeDTO));
        return this.toDTO(type);
    }

    private void verifyIfExists(String typeName) {
        repository.findByName(typeName)
        .ifPresent((type) -> { 
            throw new EntityExistsException("type already exists");
        });
    }
    
}
