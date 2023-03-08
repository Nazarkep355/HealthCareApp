package com.example.healthcareapp.service;

import com.example.healthcareapp.entity.*;
import com.example.healthcareapp.entity.Record;
import com.example.healthcareapp.repos.*;
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
    @Autowired
    private MedicalCardRepository cardRepository;
    @Autowired
    private MedicalDataRepository dataRepository;
    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

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
        Record record = Record.builder()
                .date(Date.from(Instant.now()))
                .doctor(doctors.get(0))
                .patient(users.get(0))
                .topic(topics.get(0))
                .id(1l)
                .build();
        record.getDate().setHours(record.getDate().getHours() + 1);
        List<Record> records = List.of(record);
        MedicalCard card = MedicalCard.builder()
                .id(1l)
                .user(users.get(0))
                .build();

        MedicalData medicalData = MedicalData.builder()
                .id(1l)
                .topic(topics.get(0))
                .medicalCard(card)
                .records(null)
                .build();
        userRepository.saveAll(users);
        mtRepository.saveAll(topics);
        doctorRepository.saveAll(doctors);
        recordRepository.saveAll(records);

        cardRepository.save(card);
        dataRepository.save(medicalData);
        MedicalRecord medicalRecord = MedicalRecord.builder()
                .id(1l)
                .medicalData(dataRepository.findById(1l).get())
                .author(doctors.get(0))
                .subject("Left leg")
                .data("Left leg is OK")
                .build();
        medicalRecordRepository.save(medicalRecord);
    }
}
