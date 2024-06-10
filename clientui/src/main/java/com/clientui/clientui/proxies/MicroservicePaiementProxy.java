package com.clientui.clientui.proxies;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.clientui.clientui.beans.PaiementBean;

//@FeignClient(/*contextId="feignPaiement",*/name = "zuul-server")
@FeignClient(name ="api-gateway", url="localhost:9005")
@RibbonClient(name = "microservice-paiement")
public interface MicroservicePaiementProxy {

	@PostMapping(value = "/MICROSERVICE-PAIEMENT/paiement")
	ResponseEntity<PaiementBean> payerUneCommande(@RequestBody PaiementBean paiement);

}
