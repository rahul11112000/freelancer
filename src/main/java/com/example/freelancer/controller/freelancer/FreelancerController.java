package com.example.freelancer.controller.freelancer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.freelancer.model.Projects;
import com.example.freelancer.model.Users;
import com.example.freelancer.repository.ProjectRepo;
import com.example.freelancer.repository.UserRepository;
import com.example.freelancer.service.UserService;

@RestController
@RequestMapping("/freelancer")
public class FreelancerController {

   @Autowired
   UserRepository userRepository;
   

   @Autowired
   UserService userService;

   @Autowired
   ProjectRepo projectRepo;

   @GetMapping("/profile")
	public Optional<Users> getDetails(Authentication authentication) {
      return userRepository.findByUsername(authentication.getName());
	}

   @PostMapping("/save")
   public String saveProfile(@RequestBody Users entity) {

   return userService.saveUsers(entity);

   }

   @GetMapping("/projects")
    public List<Projects> getProjects(Authentication authentication){
        return (List<Projects>) projectRepo.findAll();
        
    } 
}
