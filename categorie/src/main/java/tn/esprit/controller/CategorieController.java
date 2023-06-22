package tn.esprit.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entity.Categorie;
import tn.esprit.exceptions.ResourceNotFoundException;
import tn.esprit.repository.ICategorieRepository;
import tn.esprit.service.ICategorieService;

@RestController
@RequestMapping(value = "API")
public class CategorieController {
	
	@Autowired
	ICategorieService service;

	@GetMapping("/getAll")
	// ok : http://localhost:8083/categorie/API/getAll
	public List<Categorie> getAllCategories() {
		System.out.println("Get All Categories ....");
		return service.getAllCategories();

	}
	// ok : http://localhost:8083/categorie/API/categorie/1

	@GetMapping("/categorie/{id}")
	public ResponseEntity<Categorie> getCategorieById(@PathVariable(value = "id") int categorieId)
			throws ResourceNotFoundException {
		return ResponseEntity.ok().body(service.getCategorieById(categorieId));
	}

	@PostMapping("/new")
	public Categorie createCategorie(@RequestBody Categorie categorie) {
		return service.createCategorie(categorie);
	}

	@DeleteMapping("/deleteCategorie/{id}")
	// ok : http://localhost:8083/categorie/API/deleteCategorie/1
	public Map<String, Boolean> deleteCategorie(@PathVariable(value = "id") int categorieId)
			throws ResourceNotFoundException {
		return service.deleteCategorie(categorieId);
	}

	@DeleteMapping("/Categories/delete")
	public ResponseEntity<String> deleteAllCategories() {
		System.out.println("Delete All Categories");
		return service.deleteAllCategories();
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Categorie> updateCategorie(@PathVariable("id") int id, @RequestBody Categorie categorie) {
		System.out.println("update Categorie with Id =" + id + " .....");
		Categorie cat = service.updateCategorie(id, categorie);
		if (cat != null) {
			return new ResponseEntity<>(cat, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
