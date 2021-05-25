package com.human.pages;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController

public class PagesController {

    @Autowired
    private Environment env;

    // TODO delete this class later, it is only for learning / testing purposes

    @RequestMapping("/")
    public String greetingHomepage() {
        return "<h1> Welcome to human homepage </h1>";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "<h1> Welcome to backoffice admin </h1>";
    }

    @RequestMapping("/env")
    public String env() {
        return env.toString();
    }

}


