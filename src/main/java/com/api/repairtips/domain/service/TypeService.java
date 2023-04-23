package com.api.repairtips.domain.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.repairtips.domain.model.assembler.ModelAssembler;
import com.api.repairtips.domain.model.dto.TypeDTO;
import com.api.repairtips.domain.model.entity.Type;

@Service
public class TypeService extends ModelAssembler<TypeDTO, Type> {

    public TypeDTO getById(UUID id) {
        return null;
    }
    
}
