package com.api.repairtips.domain.service.support;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.repairtips.domain.model.conversor.ModelConversor;
import com.api.repairtips.domain.model.dto.support.TypeDTO;
import com.api.repairtips.domain.model.dto.support.TypeWithEmbeddedListsDTO;
import com.api.repairtips.domain.model.entity.Type;
import com.api.repairtips.domain.repository.TypeRepository;
import com.api.repairtips.domain.service.interfaces.IcrudService;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TypeService implements IcrudService<TypeDTO>, ModelConversor<TypeDTO, Type> {
    
    private final TypeRepository repository;
    private final TypeWithEmbeddedListService embeddedListService;

    @Transactional(readOnly = true)
    public Page<TypeDTO> findAll(Pageable pageable) {

        if (Objects.nonNull(pageable)) {
            Page<Type> all = repository.findAll(pageable);
            return toCollectionDTO(all);
        }
        throw new IllegalArgumentException("Parâmetro inválido!");
    }

    // @Transactional(readOnly = true)
    public TypeDTO findById(Long id) {
        Optional<Type> entity = repository.findById(id);
        return toDTO(entity.get());
    }

    @Transactional(readOnly = true)
    public Page<TypeWithEmbeddedListsDTO> findAllWithEmbeddedLists(Pageable pageable) {
        return this.embeddedListService.toCollectionDTO(repository.findAll(pageable));
    }

    @Transactional
    public TypeDTO create(TypeDTO dto) {
        hasConflict(dto);
        return toDTO(repository.saveAndFlush(toEntity(dto)));
    }

    private void hasConflict(TypeDTO dto) {
        if (repository.findByName(dto.getName()).isPresent()) {
            new EntityExistsException("ENTITY_ALREADY_EXISTS");
        }
    }

    @Transactional
    public void delete(Long id) {
        repository.delete(repository.findById(id).get());
        repository.flush();
    }

    @Transactional
    public TypeDTO update(TypeDTO dto) {
        Type type = repository.findById(dto.getId()).get();
        BeanUtils.copyProperties(toEntity(dto), type, "id");
        return toDTO(repository.saveAndFlush(type));
    }

    // alternativa para filtro com example, isso seria via parametros via get :(
    public List<Type> filterFind(Type filter) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Type> example = Example.of(filter, matcher);
        return repository.findAll(example);
    }
}
