package com.clientui.clientui.proxies;


import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.clientui.clientui.beans.CommandeBean;

//@FeignClient(/*contextId="feignCommande",*/name = "zuul-server")
@FeignClient(name ="api-gateway", url="localhost:9005")
@RibbonClient(name = "microservice-commandes")
public interface MicroserviceCommandeProxy {

	@PostMapping(value = "/MICROSERVICE-COMMANDES/commandes")
    CommandeBean ajouterCommande(@RequestBody CommandeBean commande);
    
	@GetMapping(value = "/MICROSERVICE-COMMANDES/commandes")
    String recupererHomePage();
}
