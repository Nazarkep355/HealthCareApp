package com.example.healthcareapp.controller;

import com.example.healthcareapp.dto.Models.CreateRecordModel;
import com.example.healthcareapp.dto.Models.DoctorModel;
import com.example.healthcareapp.dto.Models.UserModel;
import com.example.healthcareapp.dto.ResponseMessage;
import com.example.healthcareapp.entity.MedicalTopic;
import com.example.healthcareapp.entity.Record;
import com.example.healthcareapp.service.RecordService;
import com.example.healthcareapp.util.ErrorCatcher;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/records")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @ApiResponse(description = "Дивиться всі записи користувача, має можливість сортування та пагінації")
    @GetMapping("/{user_id}")
    public ResponseEntity getAllUsersRecords(@PathVariable("user_id") Long user_id, Pageable pageable) {
        try {
            return ResponseEntity.ok(recordService.getAllRecordsOfUser(pageable, user_id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON)
                    .body(ResponseMessage.customMessage(e.getMessage()));
        }
    }

    @PostMapping
    @ApiResponse(description = "Створює запис до лікаря по ід лікаря, топіку, юзера, дати, якщо є лікар," +
            " не вільний на цей час, буде намагатися знайти вільного")
    public ResponseEntity createRecord(String date,
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
        return ErrorCatcher.catchException(()->recordService.createByRecordModel(recordModel));
    }





}
