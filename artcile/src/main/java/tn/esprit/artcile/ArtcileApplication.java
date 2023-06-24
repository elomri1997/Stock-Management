package tn.esprit.artcile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import tn.esprit.artcile.entity.Article;
import tn.esprit.artcile.repository.ArticleRepository;

@SpringBootApplication
@EnableEurekaClient
public class ArtcileApplication {

    @Autowired
    ArticleRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(ArtcileApplication.class, args);
    }

    @Bean
    ApplicationRunner init() {
        return (args) -> {
            // save
            repository.save(new Article(1L, "code1", "libelle1", 2, 3, 6, 10, 3, 30,10, "image1", 1));
            repository.save(new Article(2L, "code1", "libelle1", 2, 3, 6, 10, 3, 30,10, "image1", 1));
            // fetch
            repository.findAll().forEach(System.out::println);

        };
    }

}
