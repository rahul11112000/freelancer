package com.example.freelancer.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/home")
    public String home() {
        return "admin login";
    }
    
}
