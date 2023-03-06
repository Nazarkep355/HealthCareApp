package com.example.healthcareapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="medical_cards")
@Getter
@Setter

@RequiredArgsConstructor
public class MedicalCard {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @JoinColumn(name="user_id")
    @OneToOne
    private User user;
    @OneToMany(mappedBy = "medicalCard")
    private List<MedicalData> medicalData;

}
