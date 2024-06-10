package com.mpaiement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//EnableFeignClients effectue des requete http client au microservice-commande pour preciser que la commande est payée et Feign client scanne les classes de microservice-paiement
@SpringBootApplication
@EnableFeignClients("com.mpaiement")
@EnableDiscoveryClient
public class MpaiementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MpaiementApplication.class, args);
	}
}
