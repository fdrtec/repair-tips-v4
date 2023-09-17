package com.api.repairtips.controller.interfaces;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.repairtips.domain.service.IcrudService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public abstract class AbstractCrudController<D, S extends IcrudService<D>> implements ControllerDocs<D> {
    
    @Autowired
    private S service;

    @Override
    public Page<D> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
    
    @Override
    public D findById(@PathVariable @NotNull @Positive UUID id){
        return service.findById(id);
    }
    
    @Override
    public D create(@RequestBody @Valid D dto){
        return service.create(dto);
    }

    @Override
    public void deleteById(@PathVariable @NotNull UUID id) {
        service.delete(id);
    }
    
    @Override
        public D update(@RequestBody @Valid D dto){
            return service.update(dto);
        }
}
