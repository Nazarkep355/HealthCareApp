package com.example.healthcareapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="medical_topics")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;


}
