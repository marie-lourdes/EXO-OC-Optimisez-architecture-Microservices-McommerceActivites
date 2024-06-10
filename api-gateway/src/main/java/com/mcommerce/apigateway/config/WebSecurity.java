package com.mcommerce.apigateway.config;

import java.beans.Customizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


/*@Configuration
@EnableWebSecurity
public class WebSecurity {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(request -> {
			request.anyRequest().authenticated();

		}).httpBasic(Customizer.withDefaults());
		return http.build();
	}
}*/
