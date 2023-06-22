package tn.esprit.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import tn.esprit.entity.Categorie;

public interface ICategorieService {
	List<Categorie> getAllCategories();

	Categorie getCategorieById(Integer id);

	Categorie createCategorie(Categorie categorie);

	Map<String, Boolean> deleteCategorie(int id);

	ResponseEntity<String> deleteAllCategories();

	Categorie updateCategorie(int id, Categorie categorie);
}
