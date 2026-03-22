package com.example.usermanagement.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserEntity {

    @Id
    public String id;
    public String email;
    public String password;
    public boolean active;
}