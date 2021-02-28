package com.hahasber.intellectuals.article;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class ArticleSrv {

    private final ArticleRepo articleRepo;

    public ArticleSrv(ArticleRepo articleRepo) {
        this.articleRepo = articleRepo;
    }


    public List<ArticleEntity> getArticles() {
        return articleRepo.findAll();
    }

    public ArticleEntity getArticles(UUID id) {
        return articleRepo.findById(id).get();
    }

    public List<ArticleEntity> getArticles(Set<String> tags) {

        return articleRepo.findByTags(tags);
    }

    public void deleteById(UUID id) {
        articleRepo.deleteById(id);
    }

    public ArticleEntity createArticle(ArticleEntity entity) {

        entity.activate(LocalDateTime.now());
        articleRepo.save(entity);
        return entity;
    }

    public ArticleEntity uploadArticle(ArticleEntity entity) {
        LocalDateTime importTime = LocalDateTime.now();
//        ArticleEntity oldEntity=articleRepo.findById(entity.getId()).get(); todo
//
        entity.activate(importTime);
        articleRepo.save(entity);
        return entity;
    }

}
