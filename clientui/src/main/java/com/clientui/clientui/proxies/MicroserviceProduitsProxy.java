package com.clientui.clientui.proxies;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.clientui.clientui.beans.ProductBean;
import com.clientui.clientui.configuration.FeignProduitsConfig;


/*-url = "localhost:9001" desactivé car  Ribbon est lié a eureka , 
 * la liste des URL configuré : microservice-produits.ribbon.listOfServers=localhost:9001,localhost:9011 (microservice-clientui.propertie du config server repo distant)
 * n est pas necessaire, ribbon recuperes les instances du microservice enregistré dans eureka server
 * 
 * -connexion avec le font 8080 n affiche pas le template 
mais sera replacé par api gateway et zuul server qui fera la requete http vers eureka server nativement relié ensemble zuul et eureka,
et chargera les Url des microservices*/
//@FeignClient(name = "microservice-produits"/*, url = "localhost:9001"*/)


//@FeignClient(/*contextId="feignProduits",*/name = "zuul-server"/*, configuration=FeignProduitsConfig.class*/)
@FeignClient(name ="api-gateway", url="localhost:9005")
@RibbonClient(name = "microservice-produits")
public interface MicroserviceProduitsProxy {
   @GetMapping( value = "/MICROSERVICE-PRODUITS/Produits")
   List<ProductBean> listeDesProduits();

   @GetMapping( value = "/MICROSERVICE-PRODUITS/Produits/{id}")
   ProductBean recupererUnProduit(@PathVariable("id") int id);

}
