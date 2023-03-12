package com.example.healthcareapp.service;


import com.example.healthcareapp.entity.MedicalTopic;
import com.example.healthcareapp.repos.MedicalTopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private MedicalTopicRepository medicalTopicRepository;

    public Page<MedicalTopic> getAllTopics(Pageable pageable){
        return medicalTopicRepository.findAll(pageable);
    }


}
