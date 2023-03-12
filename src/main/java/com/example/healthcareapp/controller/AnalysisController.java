package com.example.healthcareapp.controller;

import com.example.healthcareapp.dto.Models.AnalysisModel;
import com.example.healthcareapp.service.AnalysesService;
import com.example.healthcareapp.util.ErrorCatcher;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analyses")
public class AnalysisController {
    @Autowired
    private AnalysesService analysesService;
    @ApiResponse(description = "Знаходить всі аналізи(майбутні і минулі) юзера")
    @GetMapping("/user/{user_id}")
    public ResponseEntity getAnalysesByUserId(@PathVariable("user_id") Long user_id, Pageable pageable){
    return ErrorCatcher.catchException(()->analysesService.getAllAnalysisOfUser(user_id,pageable));
    }

}
