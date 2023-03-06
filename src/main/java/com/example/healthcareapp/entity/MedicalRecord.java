package com.example.healthcareapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "medical_records")
@Getter
@Setter

@RequiredArgsConstructor
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String subject;
    @Column
    private String data;
    @ManyToOne
    @JoinColumn(name="author_id")
    private Doctor author;
    @ManyToOne
    @JoinColumn(name = "data_id")
    private MedicalData medicalData;

}
