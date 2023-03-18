package com.example.healthcareapp.dto.Models;

import com.example.healthcareapp.entity.Doctor;
import com.example.healthcareapp.entity.MedicalTopic;
import com.example.healthcareapp.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class RecordModel {

    private Long id;

    private UserModel patient;

    private DoctorModel doctor;

    private MedicalTopic topic;
    private Date date;
}
