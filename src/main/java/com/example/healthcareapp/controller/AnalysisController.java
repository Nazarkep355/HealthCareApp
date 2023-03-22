package com.example.healthcareapp.controller;

import com.example.healthcareapp.dto.Models.*;
import com.example.healthcareapp.dto.ResponseMessage;
import com.example.healthcareapp.entity.MedicalTopic;
import com.example.healthcareapp.service.AnalysesService;
import com.example.healthcareapp.util.ErrorCatcher;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/analyses")
public class AnalysisController {
    @Autowired
    private AnalysesService analysesService;

    @ApiResponse(description = "Знаходить всі аналізи(майбутні і минулі) юзера")
    @GetMapping("/user/{user_id}")
    public ResponseEntity getAnalysesByUserId(@PathVariable("user_id") Long user_id, Pageable pageable) {
        return ErrorCatcher.catchException(() -> analysesService.getAllAnalysisOfUser(user_id, pageable));
    }

    @PostMapping
    public ResponseEntity scheduleAnalysis(String date,
                                           Long user_id,
                                           Long doctor_id,
                                           Long subject_id) {
        Date date1 = null;
        if (StringUtils.isNumeric(date)) {
            date1 = new Date(Long.parseLong(date));
        } else {
            date1 = java.sql.Timestamp.valueOf(LocalDateTime.parse(date));
        }
        AnalysisModel analysisModel = AnalysisModel.builder()
                .user(UserModel.builder().id(user_id).build())
                .author(DoctorModel.builder().id(doctor_id).build())
                .subject(SubjectModel.builder().id(subject_id).build())
                .build();

        return ErrorCatcher.catchException(() -> analysesService.scheduleAnalysis(analysisModel));


    }
    @GetMapping("/subjects")
    public ResponseEntity getAllSubjects(Pageable pageable){
        return ErrorCatcher.catchException(()->analysesService.getAllSubjects(pageable));
    }
}
