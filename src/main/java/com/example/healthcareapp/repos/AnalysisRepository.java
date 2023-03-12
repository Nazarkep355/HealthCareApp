package com.example.healthcareapp.repos;

import com.example.healthcareapp.entity.Analysis;
import com.example.healthcareapp.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface AnalysisRepository  extends JpaRepository<Analysis,Long> {
    Page<Analysis> findAllByUser(User user, Pageable pageable);
}
