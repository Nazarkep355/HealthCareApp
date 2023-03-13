package com.example.healthcareapp.controller;

import com.example.healthcareapp.dto.Models.AnalysisModel;
import com.example.healthcareapp.dto.Models.CreateRecordModel;
import com.example.healthcareapp.dto.Models.DoctorModel;
import com.example.healthcareapp.dto.Models.UserModel;
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
                                           Long topic_id) {
        Date date1 = null;
        if (StringUtils.isNumeric(date)) {
            date1 = new Date(Long.parseLong(date));
        } else {

            date1 = java.sql.Timestamp.valueOf(LocalDateTime.parse(date));
        }
        CreateRecordModel recordModel = CreateRecordModel.builder()
                .topic(MedicalTopic.builder().id(topic_id).build())
                .author(DoctorModel.builder().id(doctor_id).build())
                .user(UserModel.builder().id(user_id).build())
                .date(date1).build();

        return ErrorCatcher.catchException(() -> analysesService.scheduleAnalysis(recordModel));


    }
}
