package com.api.repairtips.domain.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
* 
 * Select no front
 * Manufactory(HP)-Type(Impressora)-Category(Laser)-Model(HP Laserjet 1100)
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "tb_type")
@Entity
public class Type extends BaseEntity<Type> {

    @Column(name = "name", nullable = false, unique = true)
    private String name;    

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_type_category", joinColumns = @JoinColumn(name = "type_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    public int compareTo(Type other) {
        return name.compareTo(other.getName());
    }

    @Override
    public String toString() {
        return "Type [name=" + name + "]";
    }

}