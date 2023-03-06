package com.example.healthcareapp.controller;

import com.example.healthcareapp.entity.User;
import com.example.healthcareapp.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LoginController {
    @Autowired
    private UserLoginService loginService;
    @PostMapping("/login")
    public ResponseEntity<User> login(String email,String password){
        Optional<User> user = loginService.login(email,password);
        if(user.isEmpty()){
            return ResponseEntity.status(403).build();
        }
        return ResponseEntity.ok(user.get());
    }
}
