package com.api.repairtips.domain.service.support;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.PageRequest;

import com.api.repairtips.domain.repository.CategoryRepository;



@RunWith(MockRunner.class)
public class CategoryServiceTest{

	@Mock
	private CategoryRepository categoryRepository;

	@InjectMocks
	private CategoryService service;

	@Test
	public void testFindAll() throws Exception {
		service.findAll(any(PageRequest.class));

	}

	// @Test
	// public void testFindById() throws Exception {

	// }

	// @Test
	// public void testCreate() throws Exception {

	// }

	// @Test
	// public void testUpdate() throws Exception {

	// }

	// @Test
	// public void testDelete() throws Exception {

	// }

}
