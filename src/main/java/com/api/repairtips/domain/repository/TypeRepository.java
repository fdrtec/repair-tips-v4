package com.api.repairtips.domain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.repairtips.domain.model.entity.Type;

public interface TypeRepository extends JpaRepository<Type, UUID> {
    Optional<Type> findByName(String name);
    
}
