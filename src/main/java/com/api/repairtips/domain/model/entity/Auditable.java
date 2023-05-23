package com.api.repairtips.domain.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable implements Serializable {

    protected static final long serialVersionUID = 1L;

    @CreatedDate
    @Column
    protected LocalDateTime createdDate;

    @LastModifiedDate
    @Column
    protected LocalDateTime lastModifiedDate;    
}
