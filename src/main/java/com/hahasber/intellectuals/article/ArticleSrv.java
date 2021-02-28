package com.hahasber.intellectuals.article;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class ArticleSrv {

    private final ArticleRepo articleRepo;
    private final TagsRepo tagsRepo;

    public ArticleSrv(ArticleRepo articleRepo, TagsRepo tagsRepo) {
        this.articleRepo = articleRepo;
        this.tagsRepo = tagsRepo;
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
        Set<TagEntity> tags=entity.getTags();
        tags.forEach(f->f.setArticle(entity));
        tagsRepo.saveAll(tags);
        return entity;
    }

    public ArticleEntity uploadArticle(ArticleEntity entity) {
        LocalDateTime importTime = LocalDateTime.now();
//        ArticleEntity oldEntity=articleRepo.findById(entity.getId()).get(); todo
        entity.activate(importTime);
        articleRepo.save(entity);
        return entity;
    }

}
