package com.hahasber.intellectuals.article;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleSrv {

    @Autowired
    private  ArticleRepo articleRepo;


    public List<ArticleEntity> getArticles() {
        return articleRepo.findAll();
    }

    public ArticleEntity getArticles(UUID id) {
        return articleRepo.findById(id).get();
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
        LocalDateTime importTime=LocalDateTime.now();
//        ArticleEntity oldEntity=articleRepo.findById(entity.getId()).get();
//
        entity.activate(importTime);
//        oldEntity.
        articleRepo.save(entity);
        return entity;
    }

}
