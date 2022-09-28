package com.example.crestananoworldfinalproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class home {

    @RestController
    public class IndexController {
        @GetMapping("/")
        public String index() {
            return "Hello there! I'm running.";
        }
    }
}
