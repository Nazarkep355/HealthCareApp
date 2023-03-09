package com.example.healthcareapp.controller;

import com.example.healthcareapp.entity.MedicalCard;
import com.example.healthcareapp.service.MedicalDataService;
import com.example.healthcareapp.util.ErrorCatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards")
public class MedicalCardController {
    @Autowired
    private MedicalDataService dataService;

    @GetMapping("/user/{user_id}")
    public ResponseEntity findByUserId(@PathVariable("user_id") Long user_id) {
       ResponseEntity responseEntity = ErrorCatcher
               .catchException(()->dataService
                       .findMedicalCardByUserId(user_id));
        return responseEntity;
    }
    @PutMapping("/put")
    public ResponseEntity findByUserId(@RequestBody MedicalCard medicalCard) {
        ResponseEntity responseEntity = ErrorCatcher.
                catchException(()->dataService.putMedicalCard(medicalCard));
        return responseEntity;
    }
}
