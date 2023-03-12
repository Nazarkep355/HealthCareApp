package com.example.healthcareapp.controller;

import com.example.healthcareapp.dto.Models.DoctorModel;
import com.example.healthcareapp.entity.Doctor;
import com.example.healthcareapp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @GetMapping()
    public Page<DoctorModel> showAllDoctors(Pageable pageable){
        return doctorService.getAllDoctors(pageable);
    }

}
