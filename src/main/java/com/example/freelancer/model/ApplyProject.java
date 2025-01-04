package com.example.freelancer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ApplyProject {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private int id;
   private int clientId;
   private int projectId;
   private int freelancerId;
   private String description;
   private String budget;
   private String skills;
   private String resume;

}
