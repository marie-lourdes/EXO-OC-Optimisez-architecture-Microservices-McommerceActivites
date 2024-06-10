package com.mexpedition.mexpedition.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mexpedition.mexpedition.model.Expedition;

public interface IExpeditionRepository extends JpaRepository<Expedition, Integer> {
	Expedition findByCommande(Integer idCommande);

}
