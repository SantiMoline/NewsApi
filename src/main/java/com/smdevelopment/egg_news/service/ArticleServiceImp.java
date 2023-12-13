package com.smdevelopment.egg_news.service;

import org.springframework.stereotype.Service;

import com.smdevelopment.egg_news.entitiy.Article;
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

}
