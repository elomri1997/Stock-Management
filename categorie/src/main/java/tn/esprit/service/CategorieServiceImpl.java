package tn.esprit.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tn.esprit.entity.Categorie;
import tn.esprit.exceptions.ResourceNotFoundException;
import tn.esprit.repository.ICategorieRepository;

@Service
public class CategorieServiceImpl implements ICategorieService{

	
	@Autowired
	ICategorieRepository repository;
	@Override
	public List<Categorie> getAllCategories() {
		List<Categorie> categories = new ArrayList<Categorie>();
		repository.findAll().forEach(categories::add);
		return categories;
	}

	@Override
	public Categorie getCategorieById(Integer id) {
		Categorie categorie;
		try {
			categorie = repository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Categorie not found for this is ::" + id));
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
		return categorie;
	}

	@Override
	public Categorie createCategorie(Categorie categorie) {
		return repository.save(categorie);
	}

	@Override
	public Map<String, Boolean> deleteCategorie(int id) {
		Categorie categorie;
		try {
			categorie = repository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Artocle not fond id ::" + id));
			repository.delete(categorie);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public ResponseEntity<String> deleteAllCategories() {
		repository.deleteAll();
		return new ResponseEntity<>("All Categories have been deleted!", HttpStatus.OK);	}

	@Override
	public Categorie updateCategorie(int id, Categorie categorie) {
		Optional<Categorie> categorieInfo = repository.findById(id);
		if (categorieInfo.isPresent()) {
			return repository.save(categorie);
		} else {
			return null;
		}
	}

}
