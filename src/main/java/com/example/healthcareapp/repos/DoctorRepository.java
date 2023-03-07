package com.example.healthcareapp.repos;

import com.example.healthcareapp.entity.Doctor;
import com.example.healthcareapp.entity.MedicalTopic;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query(value = "select d from Doctor d, Record r where r.date<?1 and d.id<>r.doctor.id and d.medicalTopic=?2 " )
    List<Doctor> findAbleDoctors( Date dateAfter, MedicalTopic topic);


    List<Doctor> findDoctorsByMedicalTopic(MedicalTopic medicalTopic);
}
