package com.api.repairtips.controller.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


public interface ControllerDocs<D> {
    
    @Operation(summary = "Persist a new data")    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public D create(@RequestBody @Valid D dto);

    @Operation(summary = "Get a data by its id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    public D findById(@PathVariable @NotNull Long id);

    @Operation(summary = "Get data List by pagination")
    @GetMapping
    public Page<D> findAll(Pageable pageable);

    @DeleteMapping("{id}")
    @Operation(summary = "Delete a data by its id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable @Valid Long id);

    @PutMapping
    @Operation(summary = "Update a data")    
    public D update(@RequestBody @Valid D dto);
}
