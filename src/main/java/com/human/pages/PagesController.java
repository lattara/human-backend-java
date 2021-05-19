package com.human.pages;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PagesController {

    // TODO delete this class later, it is only for learning / testing purposes
    @RequestMapping("/")
    public String greetingHomepage() {
        return "<h1> Welcome to human homepage </h1>";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "<h1> Welcome to backoffice admin </h1>";
    }

}


