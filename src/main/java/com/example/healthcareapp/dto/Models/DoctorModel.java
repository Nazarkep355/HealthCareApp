package com.example.healthcareapp.dto.Models;

import com.example.healthcareapp.entity.MedicalTopic;
import com.example.healthcareapp.entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
@Getter
@Setter
public class DoctorModel {

    private Long id;

    private UserModel user;

    private MedicalTopic medicalTopic;

}
