package com.example.freelancer.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.freelancer.model.ClientProfile;
import java.util.List;


public interface ClientProfileRepo extends CrudRepository<ClientProfile,Integer>{
    
    List<ClientProfile> findByUsername(String username);
}
