package com.example.healthcareapp.service;

import com.example.healthcareapp.dto.Models.CreateRecordModel;
import com.example.healthcareapp.dto.Models.UserModel;
import com.example.healthcareapp.entity.Doctor;
import com.example.healthcareapp.entity.MedicalTopic;
import com.example.healthcareapp.entity.Record;
import com.example.healthcareapp.entity.User;
import com.example.healthcareapp.repos.DoctorRepository;
import com.example.healthcareapp.repos.MedicalTopicRepository;
import com.example.healthcareapp.repos.RecordRepository;
import com.example.healthcareapp.repos.UserRepository;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecordService {
    @Autowired
    private RecordRepository rRepository;
    @Autowired
    private UserRepository uRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private MedicalTopicRepository mtRepository;
    @Autowired
    private ModelMapperMyImpl mapperMy;

    public Page<Record> getAllRecordsOfUser(Pageable pageable,Long user_id){
        Optional<User> userOptional = uRepository.findById(user_id);
        if(userOptional.isEmpty()){
            throw new IllegalArgumentException("User Not Found");
        }
        return rRepository.findAllByPatient(userOptional.get(),pageable);

    }

    public Record createNewRecord(Record record){
        record.setPatient(uRepository.findById(record.getPatient().getId()).orElseThrow(()->new IllegalArgumentException("Patient not found")));
        record.setDoctor(doctorRepository.findById(record.getDoctor()
                .getId()).orElseThrow(()->new IllegalArgumentException("Doctor not found")));
        record.setTopic(mtRepository.findById(record.getTopic().getId())
                .orElseThrow(()->new IllegalArgumentException("Topic not found")));
        Date dateBefore = new Date(record.getDate().getTime());
        dateBefore.setHours(dateBefore.getHours()-1);
        Date dateAfter = new Date(record.getDate().getTime());
        dateAfter.setHours(dateAfter.getHours()+1);
        List<Record> blockedRecords = rRepository
                .findAllByDateAndAndDateAfter(dateBefore,dateAfter,record.getTopic());
        List<Doctor> blockedDoctors = blockedRecords.stream()
                .map(Record::getDoctor)
                .toList();
        if(blockedDoctors.contains(record.getDoctor())){
            List<Doctor> doctors = doctorRepository.findDoctorsByMedicalTopic(record.getTopic());
            doctors.removeAll(blockedDoctors);
            if(doctors.size()<1) {
                throw new IllegalArgumentException("No free doctor");
            }
            record.setDoctor(doctors.get(0));
        }
        record.setId(null);
        return rRepository.save(record);
    }

    public CreateRecordModel createByRecordModel(CreateRecordModel createRecordModel){
        Record record = mapperMy.mapClass(createRecordModel,Record.class);
        record.setPatient(uRepository.findById(createRecordModel.getUser().getId())
                .orElseThrow(()->new IllegalArgumentException("User not found")));
        record.setDoctor(doctorRepository.findById(createRecordModel.getAuthor().getId())
                .orElseThrow(()->new IllegalArgumentException("Doctor not found")));
        record = createNewRecord(record);
        createRecordModel = mapperMy.mapClass(record,CreateRecordModel.class);
        createRecordModel.setUser(mapperMy.mapClass(record.getPatient(), UserModel.class));
        return createRecordModel;


    }
    public Page<Record> getAllRecordsOfDoctor(Pageable pageable,Long doctor_id){
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctor_id);
        if(doctorOptional.isPresent()){
            throw new IllegalArgumentException("Doctor not found");
        }
        return rRepository.findAllByDoctor(doctorOptional.get(),pageable);
    }


}
