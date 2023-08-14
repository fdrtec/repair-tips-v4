package com.api.repairtips.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.api.repairtips.domain.service.IcrudService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
abstract class AbstractCrudController<D, S extends IcrudService<D>> {
    
    protected final S service;

    protected List<D> getAll(){
        return service.getAll();

    }    
}
