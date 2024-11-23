package com.example.computerstore;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class WebController {
    @GetMapping("/")
    public String index() {
        return "hello world";
    }
}