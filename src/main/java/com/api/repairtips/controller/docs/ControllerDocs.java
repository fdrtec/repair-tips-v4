package com.api.repairtips.controller.docs;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

}
