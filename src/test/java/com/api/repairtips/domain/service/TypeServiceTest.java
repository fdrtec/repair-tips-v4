package com.api.repairtips.domain.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.api.repairtips.domain.repository.TypeRepository;
import com.api.repairtips.domain.service.support.TypeService;

@ExtendWith(MockitoExtension.class)
public class TypeServiceTest {

    @Mock
    private TypeRepository repository;

    @InjectMocks
    private TypeService service;   
    
    
    @Test
    void testCreate() {
        Assertions.assertNotNull(repository);

    }

    @Test
    void testDeleteById() {

    }

    @Test
    void testFindAll() {

    }

    @Test
    void testFindById() {

    }

    @Test
    void testUpdate() {

    }
}
