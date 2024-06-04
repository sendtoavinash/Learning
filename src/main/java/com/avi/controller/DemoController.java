package com.avi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class DemoController {

    @GetMapping(value = "/test", produces = "text/html")
    public String home() {

        return "Welcome to Home page of Demo Service";
    }
}
