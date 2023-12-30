package com.api.repairtips.domain.model.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
@Getter
public abstract class BaseEntity<T> implements Serializable, Comparable<T> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (this == o)
            return true;

        if (o instanceof BaseEntity that) {
            return this.id != null && Objects.equals(this.id, that.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
