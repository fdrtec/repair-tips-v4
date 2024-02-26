package com.api.repairtips.core.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public interface ModelMapperConfig {

    @Bean
    default ModelMapper mapper() {
        return new ModelMapper();
    }    
}