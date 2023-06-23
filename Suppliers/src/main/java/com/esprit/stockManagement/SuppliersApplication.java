package com.esprit.stockManagement;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.esprit.stockManagement.entities.Supplier;
import com.esprit.stockManagement.repositories.ISupplierRepository;


@EnableEurekaClient
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class SuppliersApplication {


	public static void main(String[] args) {
		SpringApplication.run(SuppliersApplication.class, args);
	}
	
	
	@Bean
	ApplicationRunner start(ISupplierRepository repo){
		
		return 
			args -> {
				Stream.of(new Supplier("Supplier1",  "tunis","Supplier1@gmail.com"),
				new Supplier ("Supplier2", "sousse","Supplier2@gmail.com"))
				.forEach(
				supplier -> {
				repo.save(supplier); });
				repo.findAll().forEach(System.out::println);
			
			

		};
	}
	


}
