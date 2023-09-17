package com.api.repairtips.domain.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IcrudService <D> {
    
    Page<D> findAll(Pageable pageable);

    D findById(UUID id);

    D create(D dto);

    D update(D dto);

    void delete(UUID id);

}
