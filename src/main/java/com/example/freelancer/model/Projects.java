package com.example.freelancer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Projects {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private int clientId;
    private String title;
    private String Duration;
    private String budger;
    private String description;
    private String skills;
    
}
