package com.api.repairtips.domain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.repairtips.domain.model.entity.Type;

public interface TypeRepository extends JpaRepository<Type, UUID> {
    Optional<Type> findByName(String name);

    // @Query("select t from type t left join fetch type.itens where t.id=:id")
    // Type findTypeFetchItens(@Param("id") UUID id);
    
    //Dono é mock só para ilustrar o pertencimento
    // List<Types> findByDono(Dono dono);
}
