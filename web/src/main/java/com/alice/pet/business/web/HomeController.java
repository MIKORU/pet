package com.alice.pet.business.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "login";
    }

    @GetMapping("/mainpage/{path}")
    public String index(@PathVariable String path) {
        return "mainpage/" + path;
    }


}
