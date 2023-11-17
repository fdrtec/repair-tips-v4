package com.api.repairtips.domain.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@EqualsAndHashCode(of = { "id" }, callSuper = false)
@Table(name = "tb_category")
@Entity
public class Category implements Comparable<Category> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    // v11.2 algaworks refinando payload = problema de atualizar objectos internos
    // @JsonIgnoreProperties(value = "name", allowGetters = true)
    // @JsonIgnore
    @ManyToMany

    @JoinTable(
        name = "tb_category_type", 
        joinColumns = @JoinColumn(name = "type_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Type> type;

    @Column(name = "active")
    private Boolean active;

    @Override
    public int compareTo(Category other) {
        return name.compareTo(other.getName());
    }

}
