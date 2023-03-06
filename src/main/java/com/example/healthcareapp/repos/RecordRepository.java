package com.example.healthcareapp.repos;

import com.example.healthcareapp.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record,Long> {
}
