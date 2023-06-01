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

import com.api.repairtips.controller.docs.TypeControllerDocs;
import com.api.repairtips.domain.model.dto.TypeDTO;
import com.api.repairtips.domain.service.TypeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/types")
@RequiredArgsConstructor
public class TypeController implements TypeControllerDocs {

    private final TypeService typeService;

    @Operation(summary = "Get type list")
    @ApiResponse(responseCode = "200", description = "Type list found")
    @GetMapping
    public List<TypeDTO> getTypes() {
        return typeService.findAll();
    }
    
    @Operation(summary = "Get a type by its id")
    @ApiResponse(responseCode = "200", description = "Type found")
    @GetMapping({"id"})
    public TypeDTO findById(@PathVariable UUID id){
        return typeService.findById(id);
    }

    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TypeDTO create(@RequestBody @Valid TypeDTO dto){
        return typeService.create(dto);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        typeService.deleteById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody @Valid TypeDTO typeDTO){
        typeService.update(typeDTO);
    }  
}
