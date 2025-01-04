package com.example.freelancer.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.freelancer.model.ApplyProject;
import java.util.List;


public interface ApplyProjectRepo extends CrudRepository<ApplyProject,Integer>{

   List<ApplyProject> findByProjectId(int projectId);
   
}
