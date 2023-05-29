package com.api.repairtips.domain.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import com.api.repairtips.domain.exception.BusinessException;
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

    public TypeDTO getById(UUID id) {        
        return this.toDTO(findById(id));
    }

    private Type findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new BusinessException(
                        new NotFoundException("ENTITY_NOT_FOUND")));
    }

    @Transactional
    public TypeDTO create(TypeDTO typeDTO) {
        verifyConflictExistence(typeDTO.getName());
        Type type = repository.saveAndFlush(this.toEntity(typeDTO));
        return this.toDTO(type);
    }

    private void verifyConflictExistence(String typeName) {
        repository.findByName(typeName)
                .ifPresent((type) -> {
                    throw new BusinessException(new EntityExistsException("ENTITY_ALREADY_EXISTS"));
                });
    }

    @Transactional
    public void deleteById(UUID id) {
        existsById(id);
        repository.deleteById(id);
            // tratamento para descarregar o banco dentro do try - algaworks
        repository.flush();
    }

    @Transactional
    public void update(TypeDTO typeDTO) {
        existsById(typeDTO.getId());
        repository.saveAndFlush(this.toEntity(typeDTO));
    }    

    private void existsById(UUID id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("ENTITY_NOT_FOUND");
        }
    }
}
