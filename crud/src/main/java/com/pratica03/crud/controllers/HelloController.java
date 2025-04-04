package com.pratica03.crud.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.pratica03.crud.services.HelloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return helloService.getHello(name);
    }

}
