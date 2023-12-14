package com.smdevelopment.egg_news.service;

import java.util.List;

import com.smdevelopment.egg_news.entitiy.Article;

public interface ArticleService {
    Article saveArticle(Article article);
    List<Article> getArticles();
    Article getArticle(Long id);
    void deleteArticle(Long id);
    Article updateArticle(Article article, Long id);
}
