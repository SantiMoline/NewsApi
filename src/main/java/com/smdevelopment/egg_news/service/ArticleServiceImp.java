package com.smdevelopment.egg_news.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.smdevelopment.egg_news.entitiy.Article;
import com.smdevelopment.egg_news.exception.EntityNotFoundException;
import com.smdevelopment.egg_news.repository.ArticleRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ArticleServiceImp implements ArticleService {
    
    ArticleRepository articleRepository;

    @Override
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public List<Article> getArticles() {
        return (List<Article>) articleRepository.findAll();
    }

    @Override
    public Article getArticle(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        return unwrapArticle(article, id); 
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public Article updateArticle(Article article, Long id) {
        Optional<Article> wrappedArticle = articleRepository.findById(id);
        Article originalArticle = unwrapArticle(wrappedArticle, id);
        originalArticle.setBody(article.getBody());
        originalArticle.setTitle(article.getTitle());

        return articleRepository.save(originalArticle);
    }

    static Article unwrapArticle(Optional<Article> article, Long id) {
        if (article.isPresent()) return article.get();
        throw new EntityNotFoundException(id, Article.class);
    }

}
