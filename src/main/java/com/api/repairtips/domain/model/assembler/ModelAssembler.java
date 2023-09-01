package com.api.repairtips.domain.model.assembler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

public abstract class ModelAssembler<T, S> {

	@Autowired
	private ModelMapper mapper;

	public S toEntity(T dto) {
		Type entityType = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		return mapper.map(dto, entityType);
	}

	public T toDTO(S model) {
		Type dtoType = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		return mapper.map(model, dtoType);
	}

	public Page<T> toCollectionDTO(Page<S> models) {
		List<T> dtos = models.stream()
				.map((S model) -> this.toDTO(model))
				.collect(Collectors.toList());
		
		return new PageImpl<T>(dtos);
	}

}
