package com.example.freelancer.controller.client;
 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.freelancer.model.Users;
import com.example.freelancer.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/client")
public class ClientController {


    @Autowired
    UserRepository userRepository;

    @GetMapping("/profile")
	public Optional<Users> getDetails(Authentication authentication) {
        return userRepository.findByUsername(authentication.getName());
	}

    @PostMapping("/save")
    public Users postMethodName(@RequestBody Users entity) {
        
        Users c = userRepository.findByUsername(entity.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + entity.getUsername()));

        c.setAddress(entity.getAddress());
        c.setRole(entity.getRole());
        c.setEmail(entity.getEmail());
        c.setName(entity.getName());
        c.setMobileNo(entity.getMobileNo());
        c.setPincode(entity.getPincode());

        userRepository.save(c);

        return entity;
    }
    
    
}
