package com.example.freelancer.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ClientProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int clientId;
    private String name;

    @Column(unique=true)
    private String email;
    private String address;

    @Column(unique = true)
    private String username;
    private String mobileNo;
    private String pincode;
    private String role;

    
}
