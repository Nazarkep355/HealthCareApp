package com.example.healthcareapp.service;

import com.example.healthcareapp.entity.Record;
import com.example.healthcareapp.entity.User;
import com.example.healthcareapp.repos.RecordRepository;
import com.example.healthcareapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

@Service
public class RecordService {
    @Autowired
    private RecordRepository rRepository;
    @Autowired
    private UserRepository uRepository;

    public Page<Record> getAllRecordsOfUser(Pageable pageable,Long user_id){
        Optional<User> userOptional = uRepository.findById(user_id);
        if(userOptional.isEmpty()){
            throw new IllegalArgumentException("User Not Found");
        }
        return rRepository.findAllByPatient(userOptional.get(),pageable);

    }
}
