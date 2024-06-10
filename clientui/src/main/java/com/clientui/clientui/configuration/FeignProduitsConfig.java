package com.clientui.clientui.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;

//@Configuration
public class FeignProduitsConfig {
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }
}