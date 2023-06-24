package tn.esprit.artcile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.artcile.entity.Article;
import tn.esprit.artcile.service.ArticleServiceImpl;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    ArticleServiceImpl articleService;

    @GetMapping("/articles")
    public List<Article> getAllArticles(){
        return articleService.getAllArticles();
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable(value = "id") Long articleId){
        Article article = articleService.getArticleById(articleId);
        if(Objects.nonNull(article)){
            return ResponseEntity.ok().body(article);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/articles")
    public Article createArticle( @RequestBody Article article){
        return articleService.createArticle(article);
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Article> deleteArticle(@PathVariable(value = "id") Long articleId){
        Article articleToDelete = articleService.getArticleById(articleId);
        if(Objects.nonNull(articleToDelete)){
            articleService.deleteArticle(articleId);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable("id") long id,
                                                 @RequestBody Article article){
        Article articleUpdated = articleService.updateArticle(article, id);
        if(Objects.nonNull(articleUpdated)){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}