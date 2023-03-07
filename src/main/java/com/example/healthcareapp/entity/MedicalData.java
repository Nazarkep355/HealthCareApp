package com.example.healthcareapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="medical_data")
@Getter
@Setter

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
