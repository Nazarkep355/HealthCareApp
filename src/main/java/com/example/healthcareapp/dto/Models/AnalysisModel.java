package com.example.healthcareapp.dto.Models;

import com.example.healthcareapp.entity.Doctor;
import com.example.healthcareapp.entity.MedicalData;
import com.example.healthcareapp.entity.MedicalTopic;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AnalysisModel {

    private Long id;

    private String subject;

    private String result;

    private Date date;

    private DoctorModel author;

    private UserModel user;

    private MedicalTopic topic;
}
