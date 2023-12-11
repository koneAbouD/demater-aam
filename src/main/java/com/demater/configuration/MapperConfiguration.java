package com.demater.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;

public class MapperConfiguration {
    @Bean
    public ObjectMapper retrieveObjectMapper() {
        return new ObjectMapper();
    }
}
