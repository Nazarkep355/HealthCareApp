package com.example.healthcareapp.service;

import com.example.healthcareapp.dto.Models.DoctorModel;
import com.example.healthcareapp.entity.Doctor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelMapperMyImpl {
    final private ModelMapper modelMapper = new ModelMapper();

    public List<DoctorModel> doctorModels(List<Doctor> doctors){
        return doctors.stream().map(doctor -> {return modelMapper.map(doctor,DoctorModel.class);})
                .collect(Collectors.toList());
    }
}
