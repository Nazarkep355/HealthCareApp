package com.example.healthcareapp.service;

import com.example.healthcareapp.entity.Doctor;
import com.example.healthcareapp.repos.DoctorRepository;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Page<Doctor> getAllDoctors(Pageable pageable){
        return doctorRepository.findAll(pageable);
    }
}
