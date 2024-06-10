package com.mexpedition.mexpedition.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Expedition {
	@Id
    @GeneratedValue
	private Integer id;
	
	@NotNull
	private Integer commande;
	
	@NotNull
	private Integer etat;
	
	public Expedition (Integer id,Integer commande,Integer etat){
		this.id=id;
		this.commande=commande;
		this.etat=etat;
	}
	
	public Expedition (){}
}
