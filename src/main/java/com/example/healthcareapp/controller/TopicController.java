package com.example.healthcareapp.controller;

import com.example.healthcareapp.entity.MedicalTopic;
import com.example.healthcareapp.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping
    public Page<MedicalTopic> showAllTopic(Pageable pageable){
        return topicService.getAllTopics(pageable);
    }


}
