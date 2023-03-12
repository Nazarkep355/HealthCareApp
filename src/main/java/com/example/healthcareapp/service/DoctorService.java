package com.example.healthcareapp.service;

import com.example.healthcareapp.dto.Models.DoctorModel;
import com.example.healthcareapp.entity.Doctor;
import com.example.healthcareapp.repos.DoctorRepository;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private ModelMapperMyImpl myMapper;
    public Page<DoctorModel> getAllDoctors(Pageable pageable){

        Page<Doctor> doctorPage = doctorRepository.findAll(pageable);
        List<DoctorModel> doctorModels = myMapper.doctorModels(doctorPage.getContent());
        Page<DoctorModel> doctorModelsPage = new PageImpl<>(doctorModels,pageable,doctorPage.getTotalPages());
        return doctorModelsPage;
    }
}
