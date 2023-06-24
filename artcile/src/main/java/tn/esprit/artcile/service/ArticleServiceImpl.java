package tn.esprit.artcile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.artcile.entity.Article;
import tn.esprit.artcile.repository.ArticleRepository;

import java.util.List;
import java.util.Objects;

@Service
public class ArticleServiceImpl implements IArtcileService{

    @Autowired
    ArticleRepository articleRepository;


    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Article getArticleById(long id) {
        return articleRepository.getById(id);
    }

    @Override
    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public boolean deleteArticle(long id) {
        Article article = this.getArticleById(id);
        if (Objects.nonNull(article)){
            articleRepository.delete(article);
            return true;
        }
        return false;
    }

    @Override
    public Article updateArticle(Article article, long id) {
        Article articleToUpdate = this.getArticleById(id);
        if (Objects.nonNull(article)){
            article.setId(articleToUpdate.getId());
            return articleRepository.save(article);
        }
        return null;
    }
}
