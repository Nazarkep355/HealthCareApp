package com.example.healthcareapp.service;

import com.example.healthcareapp.entity.MedicalCard;
import com.example.healthcareapp.entity.User;
import com.example.healthcareapp.entity.UserRole;
import com.example.healthcareapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataGenerator {
    @Autowired
    private UserRepository userRepository;

    public void generate(){
        User user = new User(1l,"email@mail.com",
                "UGFzc3dvcmQ=",
                "Andy","Daniel", UserRole.Patient,
                null);
        userRepository.save(user);
    }
}
