package com.example.healthcareapp.controller;

import com.example.healthcareapp.dto.ResponseMessage;
import com.example.healthcareapp.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/records")
public class RecordController {

    @Autowired
    private RecordService recordService;
    @GetMapping("/{user_id}")
    public ResponseEntity getAllUsersRecords(@PathVariable("user_id") Long user_id, Pageable pageable){
        try{
            return ResponseEntity.ok(recordService.getAllRecordsOfUser(pageable,user_id));
        }catch (IllegalArgumentException e){
          return ResponseEntity.unprocessableEntity().body(ResponseMessage.customMessage(e.getMessage()));
        }
    }
}
