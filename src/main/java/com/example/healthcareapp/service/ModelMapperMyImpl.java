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
        return listOfModels(doctors,DoctorModel.class);
    }


    public <T,C> List<T> listOfModels(List<C> objects,Class<T> tClass){
        return objects.stream().map(object->{return modelMapper.map(object,tClass);})
                .collect(Collectors.toList());
    }
}
