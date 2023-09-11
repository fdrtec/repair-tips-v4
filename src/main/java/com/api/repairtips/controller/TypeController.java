package com.api.repairtips.controller;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.repairtips.controller.docs.ControllerDocs;
import com.api.repairtips.domain.model.dto.TypeDTO;
import com.api.repairtips.domain.service.TypeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequestMapping("/types")
@RequiredArgsConstructor
public class TypeController implements ControllerDocs<TypeDTO> {

    private final TypeService typeService;

    @Override
    public Page<TypeDTO> findAll(Pageable pageable) {
        return typeService.findAll(pageable);
    }
    
    @Override
    public TypeDTO findById(@PathVariable @NotNull @Positive UUID id){
        return typeService.findById(id);
    }
    
    @Override
    public TypeDTO create(@RequestBody @Valid TypeDTO dto){
        return typeService.create(dto);
    }

    @Override
    public void deleteById(@PathVariable UUID id) {
        typeService.delete(id);
    }

    @Override
    public TypeDTO update(@RequestBody @Valid TypeDTO typeDTO){
        return typeService.update(typeDTO);
    }
        
}
