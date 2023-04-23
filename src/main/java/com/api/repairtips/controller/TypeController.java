package com.api.repairtips.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.repairtips.domain.model.dto.TypeDTO;
import com.api.repairtips.domain.service.TypeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/types")
public class TypeController {

    @Operation(summary = "Get all types")
    @ApiResponse(responseCode = "200", description = "Type list found")
    @GetMapping
    public String getTypes() {
        return "Types";
    }

    @Autowired
    private TypeService typeService;

    @Operation(summary = "Get a type by its id")
    @ApiResponse(responseCode = "200", description = "Type found")
    @GetMapping({"id"})
    public TypeDTO getById(@PathVariable UUID id){
        return typeService.getById(id);
    }
    
}
