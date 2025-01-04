package com.example.freelancer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AssignProject {
   @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private int clientId;
    private int freelancerId;
    private int finalBudget;
    private int assign = 0;
}
