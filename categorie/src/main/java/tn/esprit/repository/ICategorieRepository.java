package tn.esprit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entity.Categorie;

@Repository
public interface ICategorieRepository extends JpaRepository<Categorie, Integer>{
	
}

