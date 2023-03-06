package com.example.healthcareapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="medical_topics")
@Getter
@Setter
@RequiredArgsConstructor
public class MedicalTopic {
    @Id
    private Long id;
    @Column
    private String name;

}
