package com.api.repairtips.domain.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IcrudService <D> {
    
    Page<D> findAll(Pageable pageable);

    D findById(Long id);

    D create(D dto);

    D update(D dto);

    void delete(Long id);

}
