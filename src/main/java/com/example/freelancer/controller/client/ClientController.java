package com.example.freelancer.controller.client;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.freelancer.model.ClientProfile;
import com.example.freelancer.model.Users;
import com.example.freelancer.repository.ClientProfileRepo;
import com.example.freelancer.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientProfileRepo clientProfileRepo;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/profile")
	public Optional<Users> getDetails(Authentication authentication) {
        return userRepository.findByUsername(authentication.getName());
	}

    @PostMapping("/save")
    public ClientProfile postMethodName(@RequestBody ClientProfile entity) {
        
        ClientProfile c = new ClientProfile();
        
        c.setClientId(entity.getClientId());
        c.setAddress(entity.getAddress());
        c.setRole(entity.getRole());
        c.setEmail(entity.getEmail());
        c.setName(entity.getName());
        c.setUsername(entity.getUsername());
        c.setMobileNo(entity.getMobileNo());
        c.setPincode(entity.getPincode());

        clientProfileRepo.save(c);

        return entity;
    }
    
    
}
