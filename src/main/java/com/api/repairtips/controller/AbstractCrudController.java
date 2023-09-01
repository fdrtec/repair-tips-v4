package com.api.repairtips.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import com.api.repairtips.domain.service.IcrudService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
abstract class AbstractCrudController<D, S extends IcrudService<D>> {
    
    protected final S service;

    protected Page<D> findAll(Pageable pageable){
        return service.findAll(pageable);
    }    
}
