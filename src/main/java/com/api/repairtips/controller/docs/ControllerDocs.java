package com.api.repairtips.controller.docs;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.api.repairtips.domain.model.dto.TypeDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

public interface ControllerDocs<D> {
    
    @Operation(summary = "Persist a new entity")    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public D create(@RequestBody @Valid D dto);

    @Operation(summary = "Get a dto by its id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    public TypeDTO findById(@PathVariable UUID id);

    @Operation(summary = "Get list of dtos")
    @GetMapping
    public Page<D> findAll(Pageable pageable);

    @DeleteMapping("{id}")
    @Operation(summary = "Delete entity by its id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id);

    @PutMapping
    @Operation(summary = "Update entity")    
    public D update(@RequestBody @Valid D dto);
}
