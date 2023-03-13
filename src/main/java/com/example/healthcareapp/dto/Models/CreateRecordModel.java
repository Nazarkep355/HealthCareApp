package com.example.healthcareapp.dto.Models;

import com.example.healthcareapp.entity.MedicalTopic;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class CreateRecordModel {
    Date date;
    UserModel user;
    DoctorModel author;
    MedicalTopic topic;
}
