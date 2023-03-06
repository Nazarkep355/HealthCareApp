package com.example.healthcareapp.repos;

import com.example.healthcareapp.entity.MedicalCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalCardRepository extends JpaRepository<MedicalCard, Long> {
}
