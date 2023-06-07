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

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "name"}, callSuper = false)
@Table(name = "tb_category")
@Entity
public class Category implements Comparable<Category> {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "category_name", nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_fk", referencedColumnName="type_id", nullable = false)
    private Type type;
    
    @Override
    public int compareTo(Category other) {
        return name.compareTo(other.getName());        
    }
    
}
