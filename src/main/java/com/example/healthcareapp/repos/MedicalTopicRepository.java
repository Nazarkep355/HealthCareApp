package com.example.healthcareapp.repos;

import com.example.healthcareapp.entity.MedicalTopic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalTopicRepository extends JpaRepository<MedicalTopic,Long> {
}
