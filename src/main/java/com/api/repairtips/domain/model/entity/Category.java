package com.api.repairtips.domain.model.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/*
* 
 * select no front
 * fabricante(hp)-tipo(impressora)-categoria(laser)-modelosEquipamentos
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"name", "type"}, callSuper = false)
@Table(name = "tb_category")
@Entity
public class Category implements Comparable<Category> {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "category_name")
    private String name;

    //v11.2 algaworks refinando payload = problema de atualizar objectos internos
    // @JsonIgnoreProperties(value = "name", allowGetters = true)
    // @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_type_fk", referencedColumnName="type_id")
    private Type type;

    @Column(name = "category_active")
    private Boolean active;
    
    @Override
    public int compareTo(Category other) {
        return name.compareTo(other.getName());        
    }
    
}
