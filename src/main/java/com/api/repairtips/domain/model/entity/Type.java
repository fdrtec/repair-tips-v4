package com.api.repairtips.domain.model.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/*
* 
 * select no front
 * Manufactory(HP)-Type(Impressora)-Category(Laser)-Model(HP Laserjet 1100)
 */

@Data
@Builder
@EqualsAndHashCode(of = {"name"}, callSuper=false)
@Table(name = "tb_type")
@Entity
public class Type extends BaseEntity<Type> {

    @Column(name = "tb_id")
    private UUID id;  

    @Column(name = "type_name", nullable = false, unique = true)
    private String name;

    public int compareTo(Type other) {
        return name.compareTo(other.getName());
    }

    // @Column(nullable = true, columnDefinition = "TIMESTAMP")
    // private LocalDateTime exampleDateColumnDefinition;

    // @Enumerated(EnumType.STRING)
    // @Column(nullable = false, length = 20 )
    // private Gender gender;

    // @Column(name = "total", precision = 20, scale = 2)
    // private BigDecimal total;

    // @OneToMany(mappedBy = "entidade onde fica o ManyToOne")
    // private List<Item> itens;

    // Não precisa declarar carregamento Lazy porque já default
    // @ManyToOne (cascade = { CascadeType.MERGE })
    // @JoinColumn(name = "entidade_id da descrição abaixo")
    // private Entidade entidade;
}
