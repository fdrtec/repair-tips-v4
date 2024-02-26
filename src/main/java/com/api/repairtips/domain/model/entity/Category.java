package com.api.repairtips.domain.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
* 
 * select no front
 * fabricante(hp)-tipo(impressora)-categoria(laser)-modelosEquipamentos
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper=false)
@Table(name = "tb_category")
@Entity
public class Category extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private Boolean active;

    // @Override
    // public int compareTo(Category other) {
    //     return name.compareTo(other.getName());
    // }

}
