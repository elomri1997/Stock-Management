package com.example.client;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class Ms1GestionClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms1GestionClientApplication.class, args);
	}

	@Bean
	ApplicationRunner start(ClientRepository repo) {
		return args -> {
			Stream.of(new Client(1, "feriel1", " 1", "ferieltlili", "ariana", "99218", "feriel.bentlili@esprit.tn", "012", "123", "004", 20, 10, null),
					new Client(1, "feriel2", " 1", null, null, null, null, null, null, null, 0, 0, null))
					.forEach(client -> {
						repo.save(client);
					});
			repo.findAll().forEach(System.out::println);

		};
	}

}
