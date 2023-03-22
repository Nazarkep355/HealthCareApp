package com.example.healthcareapp.service;

import com.example.healthcareapp.entity.*;
import com.example.healthcareapp.entity.Record;
import com.example.healthcareapp.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private AnalysisRepository analysisRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    private static List<User> users = new ArrayList<>();
    private static List<MedicalTopic> topics = new ArrayList<>();
    private static List<Doctor> doctors = new ArrayList<>();
    private static List<MedicalCard> cards = new ArrayList<>();
    private static List<Record> records = new ArrayList<>();
    private static List<MedicalData> data = new ArrayList<>();
    private static List<Analysis> analyses = new ArrayList<>();
    private static List<MedicalRecord> medicalRecords = new ArrayList<>();
    private static List<AnalysisSubject> subjects = new ArrayList<>();

    private List<User> createUsers() {

        users.add(User.builder()
                .id(2l)
                .role(UserRole.Doctor)
                .email("doctor@gmail.com")
                .firstName("John")
                .secondName("Watson")
                .password("SDBsbWVzU2hlcmxvY2s=")
                .medicalCard(null)
                .build());
        users.add(User.builder()
                .id(6l)
                .role(UserRole.Doctor)
                .email("doctor1@gmail.com")
                .firstName("Lucius")
                .secondName("Fox")
                .password("UGFzc3dvcmQ=")
                .medicalCard(null)
                .build());
        users.add(User.builder()
                .id(7l)
                .role(UserRole.Doctor)
                .email("doctor2@gmail.com")
                .firstName("Akiko")
                .secondName("Yosano")
                .password("UGFzc3dvcmQ=")
                .medicalCard(null)
                .build());

        users.add(User.builder()
                .id(9l)
                .role(UserRole.Doctor)
                .email("doctor3@gmail.com")
                .firstName("Orihime")
                .secondName("Inoue")
                .password("UGFzc3dvcmQ=")
                .medicalCard(null)
                .build());

        users.add(new User(1l, "email@mail.com",
                "UGFzc3dvcmQ=",
                "Andy", "Daniel", UserRole.Patient,
                null));
        users.add(User.builder()
                .id(3l)
                .role(UserRole.Patient)
                .email("user1@gmail.com")
                .firstName("Sherlock")
                .secondName("Holmes")
                .password("UGFzc3dvcmQ=")
                .medicalCard(null)
                .build());
        users.add(User.builder()
                .id(4l)
                .role(UserRole.Patient)
                .email("user2@gmail.com")
                .firstName("Jim")
                .secondName("Gordon")
                .password("UGFzc3dvcmQ=")
                .medicalCard(null)
                .build());
        users.add(User.builder()
                .id(5l)
                .role(UserRole.Patient)
                .email("user3@gmail.com")
                .firstName("Barbara")
                .secondName("Gordon")
                .password("UGFzc3dvcmQ=")
                .medicalCard(null)
                .build());

        users.add(User.builder()
                .id(8l)
                .role(UserRole.Patient)
                .email("user4@gmail.com")
                .firstName("Dazai")
                .secondName("Osamu")
                .password("UGFzc3dvcmQ=")
                .medicalCard(null)
                .build());
        List<User> sorted = users.stream().sorted((a, b) -> a.getId().compareTo(b.getId())).collect(Collectors.toList());
        return userRepository.saveAll(sorted);

    }

    private List<Doctor> createDoctors() {
        doctors.add(Doctor.builder()
                .user(users.get(0))
                .id(1l)
                .medicalTopic(topics.get(4))
                .build());
        doctors.add(Doctor.builder()
                .user(users.get(1))
                .id(2l)
                .medicalTopic(topics.get(1))
                .build());
        doctors.add(Doctor.builder()
                .user(users.get(2))
                .id(3l)
                .medicalTopic(topics.get(2))
                .build());
        doctors.add(Doctor.builder()
                .user(users.get(3))
                .id(4l)
                .medicalTopic(topics.get(3))
                .build());
        return doctorRepository.saveAll(doctors);
    }

    private List<MedicalTopic> createTopics() {
        topics.add(
                MedicalTopic.builder()
                        .name("Surgery")
                        .id(1l)
                        .build());
        topics.add(
                MedicalTopic.builder()
                        .name("Ophthalmology")
                        .id(2l)
                        .build());
        topics.add(
                MedicalTopic.builder()
                        .name("Gastroenterology")
                        .id(3l)
                        .build());
        topics.add(
                MedicalTopic.builder()
                        .name("Dentistry")
                        .id(4l)
                        .build());
        topics.add(
                MedicalTopic.builder()
                        .name("Oncology")
                        .id(5l)
                        .build());
        return mtRepository.saveAll(topics);
    }

    private List<AnalysisSubject> createSubjects() {

        subjects.add(AnalysisSubject.builder()
                .id(1l)
                .name("α-fetoprotein")
                .topic(topics.stream().filter(a -> a.getName().equals("Oncology"))
                        .findAny().orElseThrow())
                .build());
        subjects.add(AnalysisSubject.builder()
                .id(2l)
                .name("Glucose")
                .topic(topics.stream().filter(a -> a.getName().equals("Oncology"))
                        .findAny().orElseThrow())
                .build());
        subjects.add(AnalysisSubject.builder()
                .id(3l)
                .name("Insulin")
                .topic(topics.stream().filter(a -> a.getName().equals("Oncology"))
                        .findAny().orElseThrow())
                .build());
        return subjectRepository.saveAll(subjects);
    }

    private List<Record> createRecords() {
        Date date1 = Date.from(Instant.now());
        date1.setHours(date1.getHours() + 1);
        Date date2 = Date.from(Instant.now());
        date2.setDate(date2.getDate() - 3);
        Date date3 = Date.from(Instant.now());
        date3.setDate(date3.getDate() - 6);
        Date date4 = Date.from(Instant.now());
        date4.setDate(date3.getDate() - 8);
        Date date5 = Date.from(Instant.now());
        date5.setDate(date3.getDate() + 5);
        records.add(Record.builder()
                .date(date1)
                .doctor(doctors.get(0))
                .patient(users.get(0))
                .topic(topics.get(0))
                .id(1l)
                .build());
        records.add(Record.builder()
                .date(date2)
                .doctor(doctors.get(0))
                .patient(users.get(0))
                .topic(topics.get(0))
                .id(2l)
                .build());
        records.add(Record.builder()
                .date(date3)
                .doctor(doctors.get(0))
                .patient(users.get(0))
                .topic(topics.get(0))
                .id(3l)
                .build());
        records.add(Record.builder()
                .date(date4)
                .doctor(doctors.get(0))
                .patient(users.get(0))
                .topic(topics.get(0))
                .id(4l)
                .build());
        records.add(Record.builder()
                .date(date5)
                .doctor(doctors.get(0))
                .patient(users.get(0))
                .topic(topics.get(0))
                .id(5l)
                .build());
        return recordRepository.saveAll(records);
    }

    private List<Analysis> createAnalyses() {
        Date date1 = Date.from(Instant.now());
        date1.setDate(date1.getDate() - 3);
        Date date2 = Date.from(Instant.now());
        date2.setDate(date1.getDate() - 2);
        Date date3 = Date.from(Instant.now());
        date3.setDate(date1.getDate() - 4);
        Date date4 = Date.from(Instant.now());
        date4.setDate(date1.getDate() - 1);
        Date date5 = Date.from(Instant.now());
        date5.setDate(date1.getDate() + 3);
        analyses.add(Analysis.builder()
                .date(date1)
                .author(doctors.get(1))
                .user(users.get(0))
                .subject(subjects.get(0))
                .result("OK")
                .id(1l)
                .build());
        analyses.add(Analysis.builder()
                .date(date2)
                .author(doctors.get(1))
                .user(users.get(0))
                .subject(subjects.get(0))
                .result("OK")
                .id(2l)
                .build());
        analyses.add(Analysis.builder()
                .date(date1)
                .author(doctors.get(1))
                .user(users.get(0))
                .subject(subjects.get(0))
                .result("OK")
                .id(3l)
                .build());
        analyses.add(Analysis.builder()
                .date(date1)
                .author(doctors.get(1))
                .user(users.get(0))
                .subject(subjects.get(0))
                .result("OK")
                .id(4l)
                .build());
        analyses.add(Analysis.builder()
                .date(date1)
                .author(doctors.get(1))
                .user(users.get(0))
                .subject(subjects.get(0))
                .id(5l)
                .build());
        return analysisRepository.saveAll(analyses);
    }

    private List<MedicalCard> createCards() {
        cards.add(MedicalCard.builder()
                .id(1l)
                .user(users.get(0))
                .build());
        cards.add(MedicalCard.builder()
                .id(2l)
                .user(users.get(1))
                .build());
        cards.add(MedicalCard.builder()
                .id(3l)
                .user(users.get(2))
                .build());
        cards.add(MedicalCard.builder()
                .id(4l)
                .user(users.get(3))
                .build());
        cards.add(MedicalCard.builder()
                .id(5l)
                .user(users.get(4))
                .build());
        cards.add(MedicalCard.builder()
                .id(6l)
                .user(users.get(5))
                .build());
        cards.add(MedicalCard.builder()
                .id(7l)
                .user(users.get(6))
                .build());
        cards.add(MedicalCard.builder()
                .id(8l)
                .user(users.get(7))
                .build());
        cards.add(MedicalCard.builder()
                .id(9l)
                .user(users.get(8))
                .build());
        return cardRepository.saveAll(cards);
    }

    private List<MedicalData> createData() {
        for (MedicalCard card : cards) {
            data.add(MedicalData.builder()
                    .id(card.getId())
                    .topic(topics.get(0))
                    .medicalCard(card)
                    .records(null)
                    .build());
        }
        return dataRepository.saveAll(data);
    }

    List<MedicalRecord> createMedRecords() {
        medicalRecords.add(MedicalRecord.builder()
                .id(1l)
                .medicalData(data.get(0))
                .author(doctors.get(0))
                .subject("Left leg")
                .data("Left leg is OK")
                .build());
        medicalRecords.add(MedicalRecord.builder()
                .id(2l)
                .medicalData(data.get(0))
                .author(doctors.get(0))
                .subject("Right leg")
                .data("Right leg is OK")
                .build());
        medicalRecords.add(MedicalRecord.builder()
                .id(3l)
                .medicalData(data.get(0))
                .author(doctors.get(0))
                .subject("Left hand")
                .data("Left hand is OK")
                .build());
        medicalRecords.add(MedicalRecord.builder()
                .id(4l)
                .medicalData(data.get(0))
                .author(doctors.get(0))
                .subject("Right hand")
                .data("Right hand is OK")
                .build());
        return medicalRecordRepository.saveAll(medicalRecords);
    }

    public void generate() {
        users = createUsers();
        topics = createTopics();
        doctors = createDoctors();
        subjects = createSubjects();
        records = createRecords();
        analyses = createAnalyses();
        cards = createCards();
        data = createData();
        medicalRecords = createMedRecords();
        users = userRepository.findAll();
        users = null;
    }
}
