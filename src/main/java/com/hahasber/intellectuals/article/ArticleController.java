package com.hahasber.intellectuals.article;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api/articles")
@AllArgsConstructor
public class ArticleController {

    private final String TEST_OPERATION_ID = "test";

    @RequestMapping( method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getArticles() {
        return TEST_OPERATION_ID;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String createArticle() {
        return TEST_OPERATION_ID;
    }

    @RequestMapping( method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public String uploadArticle() {
        return TEST_OPERATION_ID;
    }
    @RequestMapping( method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteArticle() {
        return TEST_OPERATION_ID;
    }

}
