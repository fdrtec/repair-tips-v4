package com.api.repairtips.core.config;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Service
public class RestTemplateConfig {
    public RestTemplate  restTemplateBase(String api) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(api));
        return restTemplate;
    }
}
