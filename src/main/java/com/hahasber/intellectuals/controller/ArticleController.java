package com.hahasber.intellectuals.controller;

import com.hahasber.intellectuals.article.ArticleEntity;
import com.hahasber.intellectuals.article.ArticleSrv;
import com.hahasber.intellectuals.article.TagEntity;
import com.hahasber.intellectuals.article.TagSrv;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final TagSrv tagSrv;
    private final ArticleSrv articleSrv;

    public ArticleController(ArticleSrv articleSrv, TagSrv tagSrv) {
        this.articleSrv = articleSrv;
        this.tagSrv = tagSrv;
    }

    @GetMapping()
    public List<ArticleEntity> getAllArticles() {
        return articleSrv.getArticles();
    }

    @GetMapping("/tags")
    public List<ArticleEntity> getAllArticlesByTags(@RequestBody Set<String> tags) {
        return articleSrv.getArticles(tags);
    }

    @GetMapping("/{id}")
    public ArticleEntity getArticles(@PathVariable UUID id) {
        return articleSrv.getArticles(id);
    }

    @DeleteMapping("/{id}")
    public void deleteArticles(@PathVariable UUID id) {
        articleSrv.deleteById(id);
    }

    @PostMapping()
    public ArticleEntity createArticles(@RequestBody ArticleEntity entity) {
        return articleSrv.createArticle(entity);
    }

    @PutMapping()
    public ArticleEntity updateArticles(@RequestBody ArticleEntity entity) {
        return articleSrv.uploadArticle(entity);
    }

    @PutMapping("/{id}")
    public ArticleEntity uploadArticle(@PathVariable UUID id, @RequestBody ArticleEntity entity) {
        entity.setId(id);
        return articleSrv.uploadArticle(entity);
    }

    @GetMapping("/suggestTags")
    public Set<TagEntity> getTags(@RequestBody ArticleEntity entity) {
        return tagSrv.suggestTags(entity);
    }
}
