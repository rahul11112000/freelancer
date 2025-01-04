package com.example.freelancer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.freelancer.model.ApplyProject;
import com.example.freelancer.model.AssignProject;
import com.example.freelancer.repository.ApplyProjectRepo;
import com.example.freelancer.repository.AssignProjectRepo;

@Service
public class ClientService {
   
   @Autowired
   AssignProjectRepo assignProjectRepo;

   public String assign(AssignProject assignProject){

      AssignProject assign = new AssignProject();
      assign.setAssign(1);
      assign.setClientId(assignProject.getClientId());
      assign.setFinalBudget(assignProject.getFinalBudget());
      assign.setFreelancerId(assignProject.getFreelancerId());

      assignProjectRepo.save(assign);
 
      return "data Add successfully";
   }
}
