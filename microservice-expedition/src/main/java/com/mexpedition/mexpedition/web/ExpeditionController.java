package com.mexpedition.mexpedition.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mexpedition.mexpedition.dao.IExpeditionRepository;
import com.mexpedition.mexpedition.exceptions.ExpeditionConflictException;
import com.mexpedition.mexpedition.exceptions.ExpeditionNotFoundException;
import com.mexpedition.mexpedition.model.Expedition;

import jakarta.validation.Valid;

@RestController
public class ExpeditionController {

	@Autowired
	IExpeditionRepository expeditionRepository;

	@PostMapping("/createExpedition")
	public ResponseEntity<Expedition> addExpedition(@Valid @RequestBody Expedition expeditionCreated) {
		Expedition existingExpedition = expeditionRepository.findByCommande(expeditionCreated.getCommande());
		if (existingExpedition != null) {
			throw new ExpeditionConflictException("Expedition already exist");
		} else {
			expeditionCreated = expeditionRepository.save(expeditionCreated);
		}

		return new ResponseEntity<Expedition>(expeditionCreated, HttpStatus.CREATED);
	}
	

	@PutMapping("/Expedition/{id}")
	public Expedition updateExpedition(@Valid @RequestBody Expedition expeditionUpdated, @PathVariable Integer id) {
		 Expedition  existingExpeditionFoundById=expeditionRepository.findById(id).get();
		 existingExpeditionFoundById.setCommande(expeditionUpdated.getCommande());
		 existingExpeditionFoundById.setEtat(expeditionUpdated.getEtat());
		return expeditionRepository.save( existingExpeditionFoundById);
	}
	
	@GetMapping("/Expedition/{id}")
	public Expedition getExpeditionById(@PathVariable Integer id) {
		 Expedition  expeditionFoundById=expeditionRepository.findById(id).get();
		if (expeditionFoundById != null) {
			throw new ExpeditionNotFoundException("Expedition not found");
		}
		return expeditionRepository.findById(id).get();
	}
	
}
