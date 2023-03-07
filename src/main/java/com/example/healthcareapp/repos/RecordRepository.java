package com.example.healthcareapp.repos;

import com.example.healthcareapp.entity.Record;
import com.example.healthcareapp.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RecordRepository extends JpaRepository<Record,Long> {

    @Query("select r from Record r where r.patient = ?1")
    Page<Record> findAllByPatient(User patient, Pageable pageable);
}
