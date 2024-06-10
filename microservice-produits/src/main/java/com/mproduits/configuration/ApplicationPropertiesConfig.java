package com.mproduits.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/*@ConfigurationProperties("mes-configs")  :
 *  précise que cette classe de configuration va récupérer des propriétés dans application.properties dont le préfixe est  mes-configs.*/
@Component
@ConfigurationProperties("mes-configs")
@RefreshScope
public class ApplicationPropertiesConfig {

	  private int limitDeProduits;

	  public int getLimitDeProduits() 
	{

	      return limitDeProduits;

	  }

	  public void setLimitDeProduits(int limitDeProduits) 
	{
	      this.limitDeProduits = limitDeProduits;
	  }
}
