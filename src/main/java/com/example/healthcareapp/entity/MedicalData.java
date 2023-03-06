package com.example.healthcareapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="medical_data")
@Getter
@Setter
@RequiredArgsConstructor
public class MedicalData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private MedicalTopic topic;
    @OneToMany(mappedBy = "medicalData")
    private List<MedicalRecord> records;
    @ManyToOne
    @JoinColumn(name ="card_id")
    private MedicalCard medicalCard;

}
