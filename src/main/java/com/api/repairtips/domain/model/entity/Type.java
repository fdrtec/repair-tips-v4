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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
* 
 * select no front
 * Manufactory(HP)-Type(Impressora)-Category(Laser)-Model(HP Laserjet 1100)
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_type")
@Entity
public class Type extends BaseEntity<Type> {    

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    // mapeamente bidirecional, sem jsonIgnore dá referencia circular
    // relacionamento bidirecional não é considerado uma boa prática
    // o mais seguro é fazer um endpoint em category buscando uma lista de
    // categories by type
    // neste caso vamos adicionar anotação no category, porque vamos precisar da
    // lista
    // @JsonIgnore
    // @OneToMany(mappedBy = "type")
    // private List<Category> categories;

    // v11.2 algaworks refinando payload = problema de atualizar objectos internos
    // @JsonIgnoreProperties(value = "name", allowGetters = true)
    // @JsonIgnore
    /* Não precisa declarar carregamento Lazy porque já default */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_type_category", joinColumns = @JoinColumn(name = "type_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

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

    // Não precisa declarar carregamento Eager porque já default
    // @ManyToOne (cascade = { CascadeType.MERGE })
    // @JoinColumn(name = "entidade_id da descrição abaixo")
    // private Entidade entidade;
}
