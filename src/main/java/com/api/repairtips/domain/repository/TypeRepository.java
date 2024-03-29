package com.api.repairtips.domain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.repairtips.domain.model.entity.Type;


public interface TypeRepository extends JpaRepository<Type, UUID> {
    Optional<Type> findByName(String name);

    // List<Type> findByNameLikeOrIdOrderById(String name, UUID id);

    // //Lança exception se existir mais de um
    // Type findOneTypeByName( String name);

    // Boolean existsByName(String name);
    
    //native query
    // @Query(value = "select * from tab_type t where t.type_name like '%:name%'", nativeQuery = true)
    
    //hql
    // @Query(value = "select t from tab_type t where t.type_name like :name")
    // List<Type> encontrarPorNome(@Param("name") String name);

    //fetch traz com type com ou sem itens
    // @Query("select t from type t left join fetch type.itens where t.id=:id")
    // Type findTypeFetchItens(@Param("id") UUID id);
    
    //Dono é mock só para ilustrar o pertencimento
    // List<Types> findByDono(Dono dono);
}
