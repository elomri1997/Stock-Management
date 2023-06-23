package com.esprit.stockManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.esprit.stockManagement.entities.Supplier;
import com.esprit.stockManagement.repositories.ISupplierRepository;










@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages = "com.esprit.stockManagement")
public class SuppliersApplication {


	public static void main(String[] args) {
		SpringApplication.run(SuppliersApplication.class, args);
		System.out.print("*********");
	}
	
	
	@Bean
	ApplicationRunner start(ISupplierRepository repo ) {
		return (args) -> {
			System.out.print("888888888888888888888888888888888");
			// save
			repo.save(new Supplier("Supplier1",  "tunis","Supplier1@gmail.com"));
			repo.save(new Supplier("Supplier2", "sousse","Supplier2@gmail.com"));

			// fetch
			repo.findAll().forEach(System.out::println);

		};
	}


}
