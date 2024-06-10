package com.clientui.clientui.proxies;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.clientui.clientui.beans.ExpeditionBean;

import jakarta.validation.Valid;

@FeignClient(name ="api-gateway")
@RibbonClient(name = "microservice-expedition")
public interface IMicroserviceExpeditionsProxy {

	@PostMapping("/MICROSERVICE-EXPEDITION/createExpedition")
	ExpeditionBean addExpedition(@Valid @RequestBody ExpeditionBean  expeditionCreated);
	
	@PutMapping("/MICROSERVICE-EXPEDITION/Expedition/{id}")
	ExpeditionBean updateExpedition(@Valid @RequestBody ExpeditionBean  expeditionUpdated, @PathVariable int id);
	
	@GetMapping("/MICROSERVICE-EXPEDITION/Expedition/{id}")
	ExpeditionBean getExpeditionById(@PathVariable int id);
	
}
