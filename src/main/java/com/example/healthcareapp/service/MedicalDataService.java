package com.example.healthcareapp.service;

import com.example.healthcareapp.entity.MedicalCard;
import com.example.healthcareapp.entity.User;
import com.example.healthcareapp.repos.MedicalCardRepository;
import com.example.healthcareapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicalDataService {
    @Autowired
    private MedicalCardRepository mCardRepository;
    @Autowired
    private UserRepository userRepository;
    public MedicalCard findMedicalCardByUser(User user){
        MedicalCard medicalCard =mCardRepository.findMedicalCardByUser(user).orElseThrow(()->new IllegalArgumentException("Card not found"));
        medicalCard.getMedicalData().forEach(a->a.setMedicalCard(null));
        medicalCard.getUser().setMedicalCard(null);
        medicalCard.getMedicalData().forEach(a->a.getRecords().forEach(b->b.setMedicalData(null)));
        return medicalCard;
    }
    public MedicalCard findMedicalCardByUserId(Long id){
        User user = userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("User not found"));
        return findMedicalCardByUser(user);
    }

}
