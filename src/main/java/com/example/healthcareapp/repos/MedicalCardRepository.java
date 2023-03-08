package com.example.healthcareapp.repos;

import com.example.healthcareapp.entity.MedicalCard;
import com.example.healthcareapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicalCardRepository extends JpaRepository<MedicalCard, Long> {
    @Query("select m from MedicalCard m where m.user = ?1")
    Optional<MedicalCard> findMedicalCardByUser(User user);
}
