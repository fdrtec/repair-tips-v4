package com.api.repairtips.domain.service.support;

import org.springframework.stereotype.Service;

import com.api.repairtips.domain.model.conversor.ModelConversor;
import com.api.repairtips.domain.model.dto.support.TypeWithEmbeddedListsDTO;
import com.api.repairtips.domain.model.entity.Type;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TypeWithEmbeddedListService implements ModelConversor<TypeWithEmbeddedListsDTO, Type> {
}
