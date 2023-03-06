package com.example.healthcareapp.service;

import com.example.healthcareapp.entity.User;
import com.example.healthcareapp.entity.UserRole;
import com.example.healthcareapp.repos.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

@Service
public class UserLoginService {
    @Autowired
    private UserRepository uRepository;

    public Optional<User> login(String email, String password) {
        Optional<User> user = uRepository.findByEmail(email);
        if (user.isEmpty()) {
            return Optional.empty();
        }
        String decodedPass = decodePassword(user.get().getPassword());
        if (decodedPass.equals(password)) {
            return user;
        }
        return Optional.empty();
    }

    public Optional<User> register(@Valid User user){
        Optional<User> userOptional = uRepository.findByEmail(user.getEmail());
        if(userOptional.isPresent()){
            return Optional.empty();
        }
        user.setRole(UserRole.Patient);
        userOptional = Optional.of(uRepository.save(user));
        return userOptional;
    }
    public static String encodePassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public static String decodePassword(String storedPassword) {
        byte[] bytes = Base64.getDecoder().decode(storedPassword);
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
