package com.example.freelancer.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.freelancer.model.Users;
import java.util.Optional;


public interface UserRepository extends CrudRepository<Users,Integer> {

    Optional<Users> findByUsername(String username);

}