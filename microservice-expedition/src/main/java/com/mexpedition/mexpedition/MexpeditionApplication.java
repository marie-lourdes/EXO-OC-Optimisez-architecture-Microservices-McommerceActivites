package com.mexpedition.mexpedition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MexpeditionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MexpeditionApplication.class, args);
	}

}
