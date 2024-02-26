package com.api.repairtips.domain.model.entity;

import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/*
* 
 * Select no front
 * Manufactory(HP)-Type(Impressora)-Category(Laser)-Model(HP Laserjet 1100)
 */

@MappedSuperclass
@Getter
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    // @Override
    // public boolean equals(Object o) {
    //     if (o == null)
    //         return false;
    //     if (this == o)
    //         return true;

    //     if (o instanceof BaseEntity that) {
    //         return this.id != null && Objects.equals(this.id, that.id);
    //     }
    //     return false;
    // }

    // @Override
    // public int hashCode() {
    //     return getClass().hashCode();
    // }


    /*
     // @Column(nullable = true, columnDefinition = "TIMESTAMP")
    // private LocalDateTime exampleDateColumnDefinition;

    // @Enumerated(EnumType.STRING)
    // @Column(nullable = false, length = 20 )
    // private Gender gender;

    // @Column(name = "total", precision = 20, scale = 2)
    // private BigDecimal total;

    // @OneToMany(mappedBy = "entidade onde fica o ManyToOne")
    // private List<Item> itens;

    // Não precisa declarar carregamento Eager porque já default
    // @ManyToOne (cascade = { CascadeType.MERGE })
    // @JoinColumn(name = "entidade_id da descrição abaixo")
    // private Entidade entidade;
     */
}
