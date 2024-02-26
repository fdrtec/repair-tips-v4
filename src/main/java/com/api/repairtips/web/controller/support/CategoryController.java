package com.api.repairtips.web.controller.support;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.repairtips.domain.model.dto.support.CategoryDTO;
import com.api.repairtips.domain.service.support.CategoryService;
import com.api.repairtips.web.controller.interfaces.AbstractCrudController;

@RestController
@RequestMapping("/categories")
public class CategoryController extends AbstractCrudController<CategoryDTO, CategoryService> {
}