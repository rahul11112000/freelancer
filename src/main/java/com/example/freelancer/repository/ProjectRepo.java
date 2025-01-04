package com.example.freelancer.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.freelancer.model.Projects;
import java.util.List;


public interface ProjectRepo extends CrudRepository<Projects,Integer>{
    List<Projects> findByClientId(int clientId);

    List<Projects> findById(int id);
}
