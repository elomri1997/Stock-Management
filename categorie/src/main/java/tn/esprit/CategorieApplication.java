package tn.esprit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import tn.esprit.entity.Categorie;
import tn.esprit.repository.ICategorieRepository;

@EnableEurekaClient
@SpringBootApplication
public class CategorieApplication {
@Autowired
ICategorieRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(CategorieApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init() {
		return (args) -> {
			// save
			repository.save(new Categorie(1, "5454", "apple"));
			repository.save(new Categorie(2, "1010", "DELL"));

			// fetch
			repository.findAll().forEach(System.out::println);

		};
	}

}
