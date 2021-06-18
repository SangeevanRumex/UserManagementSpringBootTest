package com.example.UserManagementSpringBoot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="user")
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String userName;
    private String city;
    private boolean deleted;
}
