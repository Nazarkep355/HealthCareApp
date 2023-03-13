package com.example.healthcareapp.dto.Models;

import com.example.healthcareapp.entity.MedicalTopic;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class CreateRecordModel {
    Date date;
    UserModel user;
    DoctorModel author;
    MedicalTopic topic;
}
