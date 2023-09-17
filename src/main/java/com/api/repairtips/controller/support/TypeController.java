package com.api.repairtips.controller.support;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.repairtips.controller.interfaces.AbstractCrudController;
import com.api.repairtips.domain.model.dto.support.TypeDTO;
import com.api.repairtips.domain.service.support.TypeService;

@RestController
@RequestMapping("/types")
public class TypeController extends AbstractCrudController<TypeDTO, TypeService> {
}
