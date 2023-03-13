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
    private Long id;
    private Date date;
    private UserModel user;
    private DoctorModel author;
    private MedicalTopic topic;
}
