package com.api.repairtips.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.repairtips.domain.model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

    // List<Category> findByType(Type type);

    // Optional<List<Type>> findByIdFetchTypes(Long id);
    
}
