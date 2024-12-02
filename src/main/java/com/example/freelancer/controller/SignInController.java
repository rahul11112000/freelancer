package com.example.freelancer.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.freelancer.model.Users;
import com.example.freelancer.repository.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@RestController
public class SignInController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/signin")
    public String signIn(@RequestBody Users user) {
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode(user.getPassword());

        Users u = new Users();
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setUsername(user.getUsername());
        u.setRole(user.getRole());
        u.setPassword(password);

        userRepository.save(u);  
        return "user Add successfully";
    }
    
}
