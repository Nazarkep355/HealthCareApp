package com.example.healthcareapp.repos;

import com.example.healthcareapp.entity.AnalysisSubject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<AnalysisSubject,Long> {
}
