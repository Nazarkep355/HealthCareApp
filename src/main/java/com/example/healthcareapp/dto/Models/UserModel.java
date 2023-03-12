package com.example.healthcareapp.dto.Models;

import com.example.healthcareapp.entity.UserRole;
import lombok.Getter;

@Getter
public class UserModel {
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public UserRole getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Long id;
    private String email;
    private String firstName;
    private String secondName;
    private UserRole role;

}
