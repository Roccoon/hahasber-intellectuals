package com.hahasber.intellectuals.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ArticleEntityNotFoundException extends RuntimeException {
    public ArticleEntityNotFoundException(String message) {
        super(message);
    }
}
