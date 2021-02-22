package com.hahasber.intellectuals.develop.controller;

import com.hahasber.intellectuals.dao.ArticleRepo;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api/developer")
@AllArgsConstructor
public class ConnectorController {


    private final String TEST_OPERATION_ID = "test";

    @RequestMapping(value = "/test", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String uploadRefRates() {
        return TEST_OPERATION_ID;
    }

}
