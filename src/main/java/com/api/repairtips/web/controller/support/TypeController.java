package com.api.repairtips.web.controller.support;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.repairtips.domain.model.dto.support.TypeDTO;
import com.api.repairtips.domain.model.dto.support.TypeWithEmbeddedListsDTO;
import com.api.repairtips.domain.service.support.TypeService;
import com.api.repairtips.web.controller.interfaces.AbstractCrudController;


@RestController
@RequestMapping("/types")
public class TypeController extends AbstractCrudController<TypeDTO, TypeService> {

    // @PreAuthorize("hasRole('admin')")
    @Override
    public Page<TypeDTO> findAll(Pageable pageable) {
        return super.findAll(pageable);
    }    
    
    @GetMapping("/embeddedLists")
    public Page<TypeWithEmbeddedListsDTO> findAllWithEmbeddedLists(Pageable pageable) {
        return service.findAllWithEmbeddedLists(pageable);
    }
}
