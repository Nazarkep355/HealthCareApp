package com.example.healthcareapp.repos;

import com.example.healthcareapp.entity.MedicalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalDataRepository extends JpaRepository<MedicalData,Long> {
}
