package com.api.repairtips.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.repairtips.domain.model.entity.Category;
import com.api.repairtips.domain.model.entity.Type;

public interface CategoryRepository extends JpaRepository<Category, UUID>{

    List<Category> findByType(Type type);

    Optional<List<Type>> findByIdFetchTypes(UUID id);
    
}
