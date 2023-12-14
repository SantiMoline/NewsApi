package com.smdevelopment.egg_news.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/all")
    public ResponseEntity<List<Article>> getArticles() {
        return new ResponseEntity<List<Article>>(articleService.getArticles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable Long id) {
        return new ResponseEntity<>(articleService.getArticle(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@Valid @RequestBody Article article, @PathVariable Long id) {
        return new ResponseEntity<Article>(articleService.updateArticle(article, id), HttpStatus.OK);
    }

}
