package com.api.repairtips.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.api.repairtips.domain.service.IcrudService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public abstract class CrudController<D, S extends IcrudService<D>> {
    
    protected final S service;

    protected List<D> findAll(){
        return service.findAll();

    }


    
}
