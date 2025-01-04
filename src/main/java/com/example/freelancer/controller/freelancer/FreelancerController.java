package com.example.freelancer.controller.freelancer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.freelancer.model.ApplyProject;
import com.example.freelancer.model.Projects;
import com.example.freelancer.model.Users;
import com.example.freelancer.repository.ProjectRepo;
import com.example.freelancer.repository.UserRepository;
import com.example.freelancer.service.FreelancerService;
import com.example.freelancer.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/freelancer")
public class FreelancerController {

   @Autowired
   UserRepository userRepository;
   

   @Autowired
   UserService userService;

   @Autowired
   ProjectRepo projectRepo;

   @Autowired
   FreelancerService freelancerService;

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

    @GetMapping("/project")
    public List<Projects> getProjectdetails(@RequestParam String id) {
        int i=Integer.parseInt(id); 
        return projectRepo.findById(i);
    }

    @GetMapping("/client/details")
    public List<Users> clientDetails(@RequestParam String clientId){

        int i=Integer.parseInt(clientId); 
        return userRepository.findById(i);
    }

    @PostMapping("/apply/project")
    public String applyProject(@RequestBody ApplyProject applyProject){
        System.out.println(applyProject);
        return freelancerService.SaveApplyProject(applyProject);
    }
    
}
