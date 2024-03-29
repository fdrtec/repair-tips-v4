package com.api.repairtips.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.repairtips.controller.docs.ControllerDocs;
import com.api.repairtips.domain.model.dto.TypeDTO;
import com.api.repairtips.domain.service.TypeService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/types")
@RequiredArgsConstructor
public class TypeController implements ControllerDocs<TypeDTO> {

    private final TypeService typeService;

    @Operation(summary = "Get list of dtos")
    @GetMapping
    public List<TypeDTO> findAll() {
        return typeService.findAll();
    }
    
    @Operation(summary = "Get a dto by its id")
    @GetMapping("{id}")
    public TypeDTO findById(@PathVariable UUID id){
        return typeService.findById(id);
    }
    
    public TypeDTO create(@RequestBody @Valid TypeDTO dto){
        return typeService.create(dto);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete entity by its id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {
        typeService.delete(id);
    }

    @PutMapping
    @Operation(summary = "Update entity")    
    public TypeDTO update(@RequestBody @Valid TypeDTO typeDTO){
        return typeService.update(typeDTO);
    }  
}
