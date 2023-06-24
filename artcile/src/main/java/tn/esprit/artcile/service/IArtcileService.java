package tn.esprit.artcile.service;

import tn.esprit.artcile.entity.Article;

import java.util.List;

public interface IArtcileService {

    List<Article> getAllArticles();
    Article getArticleById(long id);

    Article createArticle(Article article);

    boolean deleteArticle(long id);

    Article updateArticle(Article article, long id);
}
