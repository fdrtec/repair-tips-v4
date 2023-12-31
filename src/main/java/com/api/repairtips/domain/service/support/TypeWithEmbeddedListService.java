package com.api.repairtips.domain.service.support;

import org.springframework.stereotype.Service;

import com.api.repairtips.domain.model.assembler.ModelAssembler;
import com.api.repairtips.domain.model.entity.Type;
import com.api.repairtips.web.dto.support.TypeWithEmbeddedListsDTO;

@Service
public class TypeWithEmbeddedListService extends ModelAssembler<TypeWithEmbeddedListsDTO, Type> {
}
