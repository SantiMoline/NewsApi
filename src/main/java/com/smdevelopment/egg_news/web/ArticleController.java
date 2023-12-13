package com.smdevelopment.egg_news.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smdevelopment.egg_news.entitiy.Article;
import com.smdevelopment.egg_news.service.ArticleService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/article")
public class ArticleController {

    ArticleService articleService;

    @PostMapping
    public ResponseEntity<Article> createArticle(@Valid @RequestBody Article article) {
        return new ResponseEntity<>(articleService.saveArticle(article), HttpStatus.CREATED);
    }

}
