package com.clientui.clientui.beans;

import lombok.Data;

@Data
public class ExpeditionBean {
	private Integer id;
	private Integer commande;
	private Integer etat;
	
	public ExpeditionBean (Integer id,Integer commande,Integer etat){
		this.id=id;
		this.commande=commande;
		this.etat=etat;
	}
	
	public ExpeditionBean (){}
}


