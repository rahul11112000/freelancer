package com.example.freelancer.controller.client;
 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.freelancer.model.ApplyProject;
import com.example.freelancer.model.AssignProject;
import com.example.freelancer.model.Projects;
import com.example.freelancer.model.Users;
import com.example.freelancer.repository.ApplyProjectRepo;
import com.example.freelancer.repository.ProjectRepo;
import com.example.freelancer.repository.UserRepository;
import com.example.freelancer.service.ClientService;
import com.example.freelancer.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/client")
public class ClientController {


    @Autowired
    UserRepository userRepository;

    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    UserService userService;

    @Autowired
    ApplyProjectRepo applyProjectRepo;

    @Autowired
    ClientService clientService;

    @GetMapping("/profile")
	public Optional<Users> getDetails(Authentication authentication) {
        return userRepository.findByUsername(authentication.getName());
	}

    @PostMapping("/save")
    public String postMethodName(@RequestBody Users entity) {

        return userService.saveUsers(entity);
    }

    @PostMapping("/add/project")
    public String addProjects(Authentication authentication,@RequestBody Projects project){
        Optional<Users> user = userRepository.findByUsername(authentication.getName());

        Projects p = new Projects();
        p.setTitle(project.getTitle());
        p.setBudget(project.getBudget());
        p.setDescription(project.getDescription());
        p.setDuration(project.getDuration());
        p.setSkills(project.getSkills());
        p.setClientId(user.get().getId());

        projectRepo.save(p);

        return " Project added successfully";
    }

    @GetMapping("/projects")
    public List<Projects> getProjects(Authentication authentication){
        Optional<Users> user = userRepository.findByUsername(authentication.getName());
        return projectRepo.findByClientId(user.get().getId());
        
    }    

    @GetMapping("/applied/freelancer")
    public List<ApplyProject> appliedFreelancer(@RequestParam String projectId) {

        int i=Integer.parseInt(projectId); 
        return applyProjectRepo.findByProjectId(i);
    }

    @PostMapping("/assign/project")
    public String assignProject(@RequestBody AssignProject entity) {
        
        
        return clientService.assign(entity);
    }
    
    
    
}
