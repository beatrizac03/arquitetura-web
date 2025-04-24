package com.pratica01.api.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {

    @GetMapping("/test")
    public String helloWorld() {
        return "Hello, World!";
    }

}
