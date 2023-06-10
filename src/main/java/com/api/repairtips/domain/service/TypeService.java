package com.api.repairtips.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
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
@Transactional(readOnly = true)
public class TypeService extends ModelAssembler<TypeDTO, Type> {

    private final TypeRepository repository;

    public List<TypeDTO> findAll() {
        return this.toCollectionDTO(repository.findAll());
    }

    public TypeDTO findById(UUID id) {
        return this.toDTO(repository.findById(id).get());
        // .orElseThrow(() -> new BusinessException(
        // new NotFoundException("ENTITY_NOT_FOUND"))));
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
        // verificar se é preciso essa validação abstractCrud
        // existsById(id);        
        repository.delete(repository.findById(id).get());        

        // tratamento para descarregar o banco dentro do try - algaworks
        repository.flush();
    }

    // @Transactional
    // public void update(TypeDTO typeDTO) {
    // existsById(typeDTO.getId());
    // repository.saveAndFlush(this.toEntity(typeDTO));
    // }

    private void existsById(UUID id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("ENTITY_NOT_FOUND");
        }
    }

    @Transactional
    public TypeDTO update(TypeDTO typeDTO) {
        Optional<Type> typeOriginal = repository.findById(typeDTO.getId());

        if (typeOriginal.isPresent()) {
            BeanUtils.copyProperties(this.toEntity(typeDTO), typeOriginal.get(), "id");
            Type typeAtualizado = repository.save(typeOriginal.get());

            return this.toDTO(typeAtualizado);
        }
        throw new NotFoundException("ENTITY_NOT_FOUND");
    }

    // examplo de sintaxe antiga (guardar o uso do orElseGet)
    public void updateOldSintaxe(Type type) {
        repository.findById(type.getId()).map(typeExistence -> {
            type.setId(typeExistence.getId());
            repository.save(type);
            return ResponseEntity.noContent().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
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
