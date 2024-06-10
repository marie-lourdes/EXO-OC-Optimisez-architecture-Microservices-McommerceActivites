package com.clientui.clientui.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignAuthConfig {
	
	@Bean
	BasicAuthRequestInterceptor mBasicAuthRequestInterceptor() {
		return  new BasicAuthRequestInterceptor("utilisateur", "rootroot");
	}

}
