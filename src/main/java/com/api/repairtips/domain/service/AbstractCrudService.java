package com.api.repairtips.domain.service;

import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.repairtips.domain.model.assembler.ModelAssembler;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
abstract class AbstractCrudService<D, E, R extends JpaRepository<E, UUID>> extends ModelAssembler<D, E>
        implements IcrudService<D> {

    protected final R repository;

    @Override
    @Transactional(readOnly = true)
    public Page<D> findAll(Pageable pageable) {
        return this.toCollectionDTO(repository.findAll(pageable), pageable);
    }    

    @Override
    public D create(D dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(UUID id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public D findById(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public D update(D dto) {
        // TODO Auto-generated method stub
        return null;
    }

}
