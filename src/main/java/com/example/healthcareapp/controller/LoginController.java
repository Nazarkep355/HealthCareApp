package com.example.healthcareapp.controller;

import com.example.healthcareapp.dto.ResponseMessage;
import com.example.healthcareapp.entity.User;
import com.example.healthcareapp.service.UserLoginService;
import com.example.healthcareapp.service.Validator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
    @Autowired
    private UserLoginService loginService;
    @Autowired
    private Validator validator;

    @PostMapping("/login")
    public ResponseEntity<User> login(User user) {
        Optional<User> userOptional = loginService.login(user.getEmail(),
                user.getPassword());
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(401).build();
        }
        return ResponseEntity.ok(userOptional.get());
    }

    @PostMapping("/register")
    public ResponseEntity register(@Valid User user) {
        Optional<ResponseEntity> reOptional = validator
                .validatePassword(user.getPassword());
        if (reOptional.isPresent()) {
            return reOptional.get();
        }
        Optional<User> userOptional = loginService.register(user);
        if(userOptional.isEmpty()){
            return ResponseEntity
                    .badRequest().contentType(MediaType.APPLICATION_JSON)
                    .body(ResponseMessage.userIsExists());
        }
        ResponseEntity<User> responseEntity =
                ResponseEntity.of(userOptional);
        return responseEntity;
    }



}
