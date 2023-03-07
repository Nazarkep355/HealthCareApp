package com.example.healthcareapp.service;

import com.example.healthcareapp.entity.*;
import com.example.healthcareapp.entity.Record;
import com.example.healthcareapp.repos.DoctorRepository;
import com.example.healthcareapp.repos.MedicalTopicRepository;
import com.example.healthcareapp.repos.RecordRepository;
import com.example.healthcareapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class DataGenerator {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private MedicalTopicRepository mtRepository;
    @Autowired
    private RecordRepository recordRepository;

    public void generate() {
        List<User> users = List.of(new User(1l, "email@mail.com",
                        "UGFzc3dvcmQ=",
                        "Andy", "Daniel", UserRole.Patient,
                        null),
                User.builder()
                        .id(2l)
                        .role(UserRole.Doctor)
                        .email("doctor@gmail.com")
                        .firstName("John")
                        .secondName("Watson")
                        .password("SDBsbWVzU2hlcmxvY2s=")
                        .medicalCard(null)
                        .build());
        List<MedicalTopic> topics = List.of(
                MedicalTopic.builder()
                        .name("Surgery")
                        .id(1l)
                        .build());
        List<Doctor> doctors = List.of(Doctor.builder()
                .user(users.get(1))
                .id(1l)
                .medicalTopic(topics.get(0))
                .build());
        Record record =Record.builder()
                .date(Date.from(Instant.now()))
                .doctor(doctors.get(0))
                .patient(users.get(0))
                .topic(topics.get(0))
                .id(1l)
                .build();
        record.getDate().setHours(record.getDate().getHours()+1);
        List<Record> records = List.of(record);
        userRepository.saveAll(users);
        mtRepository.saveAll(topics);
        doctorRepository.saveAll(doctors);
        recordRepository.saveAll(records);

    }
}
