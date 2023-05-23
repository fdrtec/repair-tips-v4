package com.api.repairtips.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.api.repairtips.domain.model.assembler.ModelAssembler;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
abstract class AbstractCrudService<D, E, R extends JpaRepository<E, UUID>> extends ModelAssembler<D,E> implements IcrudService<D>{

    protected final R repository;

    @Override
    public List<D> getAll(){
        return this.toCollectionDTO(repository.findAll());        
    }
    
}
