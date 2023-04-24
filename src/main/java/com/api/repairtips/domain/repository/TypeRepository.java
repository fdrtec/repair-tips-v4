package com.api.repairtips.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.repairtips.domain.model.entity.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, UUID> {
    
}
