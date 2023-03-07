package com.example.healthcareapp.repos;

import com.example.healthcareapp.entity.Doctor;
import com.example.healthcareapp.entity.MedicalTopic;
import com.example.healthcareapp.entity.Record;
import com.example.healthcareapp.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface RecordRepository extends JpaRepository<Record,Long> {

    @Query("select r from Record r where r.patient = ?1")
    Page<Record> findAllByPatient(User patient, Pageable pageable);

    @Query("select r from Record r where r.doctor = ?1")
    Page<Record> findAllByDoctor(Doctor doctor, Pageable pageable);

    @Query("select r from Record r where r.date >?1 and r.date < ?2 and r.topic = ?3")
    List<Record> findAllByDateAndAndDateAfter(Date dateBefore, Date dateAfter, MedicalTopic medicalTopic);
}
