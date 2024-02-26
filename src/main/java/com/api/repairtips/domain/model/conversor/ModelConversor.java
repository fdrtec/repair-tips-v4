package com.api.repairtips.domain.model.conversor;

import java.lang.reflect.Type;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import com.api.repairtips.core.config.ModelMapperConfig;

@Component
public interface ModelConversor<D, E> extends ModelMapperConfig {

	default E toEntity(D dto) {
		Type entityType = getClass().getGenericSuperclass();
		return mapper().map(dto, entityType);
	}

	default D toDTO(E entity) {
		Type dtoType = getClass().getGenericSuperclass();
		return mapper().map(entity, dtoType);
	}

	@SuppressWarnings({ "null" })
	default Page<D> toCollectionDTO(Page<E> entities) {
		return new PageImpl<>(entities.stream()
				.map(this::toDTO)
				.collect(Collectors.toList()), 
				entities.getPageable(), 
				entities.getTotalElements());
	}
}