package com.mproduits.web.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mproduits.configuration.ApplicationPropertiesConfig;
import com.mproduits.dao.ProductDao;
import com.mproduits.model.Product;
import com.mproduits.web.exceptions.ProductNotFoundException;

@RestController
public class ProductController implements HealthIndicator {
	org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductDao productDao;

	@Autowired
	ApplicationPropertiesConfig appProperties; // properties personnalisé :mes-configs.limitDeProduits= 4

	/*
	 * surcharger method health de l interfae HealthIndicator de Spring Actuator et
	 * personnaliser l indicateur health à down si il n y a pas de produits ds la
	 * BDD ou up si il y en a
	 */
	@Override
	public Health health() {
		List<Product> products = productDao.findAll();

		if (products.isEmpty()) {
			return Health.down().build();
		}

		return Health.down().build();
	}

	// Affiche la liste de tous les produits disponibles
	@GetMapping(value = "/Produits")
	public List<Product> listeDesProduits() {

		List<Product> products = productDao.findAll();

		if (products.isEmpty())
			throw new ProductNotFoundException("Aucun produit n'est disponible à la vente");

		List<Product> listeLimitee = products.subList(0, appProperties.getLimitDeProduits());

		log.info("Récupération de la liste des produits");

		return listeLimitee;

	}

	// Récuperer un produit par son id
	@GetMapping(value = "/Produits/{id}")
	public Optional<Product> recupererUnProduit(@PathVariable int id) {

		Optional<Product> product = productDao.findById(id);

		if (!product.isPresent())
			throw new ProductNotFoundException("Le produit correspondant à l'id " + id + " n'existe pas");

		return product;
	}
}
