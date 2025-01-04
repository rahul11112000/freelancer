package com.example.freelancer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.freelancer.model.ApplyProject;
import com.example.freelancer.repository.ApplyProjectRepo;

@Service
public class FreelancerService {

   @Autowired
   ApplyProjectRepo applyProjectRepo;

   public String SaveApplyProject(ApplyProject applyProject){

      ApplyProject data = new ApplyProject();
      data.setClientId(applyProject.getClientId());
      data.setProjectId(applyProject.getProjectId());
      data.setFreelancerId(applyProject.getFreelancerId());
      data.setBudget(applyProject.getBudget());
      data.setDescription(applyProject.getDescription());
      data.setSkills(applyProject.getSkills());
      data.setResume(applyProject.getResume());

      applyProjectRepo.save(data);
 
      return "data Add successfully";
   }
}
