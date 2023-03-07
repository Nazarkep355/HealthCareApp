package com.example.healthcareapp.controller;

import com.example.healthcareapp.dto.ResponseMessage;
import com.example.healthcareapp.entity.Record;
import com.example.healthcareapp.service.RecordService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
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
    public ResponseEntity createRecord(@RequestBody Record record) {
        try {
            return ResponseEntity.ok(recordService.createNewRecord(record));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON)
                    .body(ResponseMessage.customMessage(e.getMessage()));
        }
    }



}
