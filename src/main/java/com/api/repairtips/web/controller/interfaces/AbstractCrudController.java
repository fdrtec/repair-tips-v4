package com.api.repairtips.web.controller.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.repairtips.domain.service.interfaces.IcrudService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public abstract class AbstractCrudController<D, S extends IcrudService<D>> implements ControllerDocs<D> {
    
    @java.lang.SuppressWarnings("java:S6813")
    @Autowired
    protected S service;
    
    @Override
    public Page<D> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
    
    @Override
    public D findById(@PathVariable @NotNull Long id){
        return service.findById(id);
    }
    
    @Override
    public D create(@RequestBody @Valid D dto){
        return service.create(dto);
    }

    @Override
    public void deleteById(@PathVariable @NotNull Long id) {
        service.delete(id);
    }
    
    @Override
        public D update(@RequestBody @Valid D dto){
            return service.update(dto);
        }
}
