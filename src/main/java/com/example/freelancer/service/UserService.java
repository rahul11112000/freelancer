package com.example.freelancer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.freelancer.model.Users;
import com.example.freelancer.repository.UserRepository;

@Service
public class UserService {
   
   @Autowired
   UserRepository userRepository;

   public String saveUsers(Users entity){

      Users c = userRepository.findByUsername(entity.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + entity.getUsername()));

        c.setAddress(entity.getAddress());
        c.setRole(entity.getRole());
        c.setEmail(entity.getEmail());
        c.setName(entity.getName());
        c.setMobileNo(entity.getMobileNo());
        c.setPincode(entity.getPincode());

        userRepository.save(c);

        return "save successfully";

   }

}
