package com.api.repairtips.domain.service;

import java.util.List;
import java.util.UUID;

public interface IcrudService <D> {
    
    List<D> getAll();

    D getById(UUID id);

    D save(D dto);

    void update(D dto);

    void delete(UUID id);

}
