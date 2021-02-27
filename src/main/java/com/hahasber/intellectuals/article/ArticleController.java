package com.hahasber.intellectuals.article;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.hahasber.intellectuals.exception.ArticleEntityNotFoundException;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import lombok.extern.log4j.Log4j2;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
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

    private final ArticleSrv articleSrv;

    public ArticleController(ArticleSrv articleSrv) {
        this.articleSrv = articleSrv;
    }

    @RequestMapping("/api/articles")

    @GetMapping()
    public List<ArticleEntity> getAllArticles() {
        return articleSrv.getArticles();
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
    public ArticleEntity uploadArticle(@PathVariable UUID id,@RequestBody ArticleEntity entity) {
        entity.setId(id);
        return articleSrv.uploadArticle(entity);
    }
    
    @PostMapping("/test")
    public ArticleEntity createTestArticles() {
        ArticleEntity entity=new ArticleEntity();
        entity.setAuthor("tester");
        entity.setArticleText("test text");
        return articleSrv.createArticle(entity);
    }
}
