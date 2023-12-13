package com.smdevelopment.egg_news.repository;

import org.springframework.data.repository.CrudRepository;

import com.smdevelopment.egg_news.entitiy.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {
        
}
