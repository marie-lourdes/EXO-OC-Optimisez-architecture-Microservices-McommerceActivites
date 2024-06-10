package com.mcommerce.apigateway.config;

import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfig {
	
	@Bean
	public  DiscoveryClientRouteDefinitionLocator locator(ReactiveDiscoveryClient dc, DiscoveryLocatorProperties dlp) {
		return new DiscoveryClientRouteDefinitionLocator(dc,dlp);
	}
	

/*	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
	    return builder.routes()
	        .route(p -> p
	            .path("/get")
	            .filters(f -> f.addRequestHeader("Hello", "World"))
	            .uri("http://httpbin.org:80"))
	        .build();
	}*/
}
