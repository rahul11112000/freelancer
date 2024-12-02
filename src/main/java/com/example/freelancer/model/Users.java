package com.example.freelancer.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Users {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String name;
    @Column(unique=true)
    private String email;
    @Column(unique=true)
    private String username;
    private String password;
    private String address;
    private String mobileNo;
    private String pincode;
    private String role;


}
