package com.example.healthcareapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name ="records")
@Getter
@Setter
@RequiredArgsConstructor
public class Record {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name="patient_id")
    private User patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name ="topic_id")
    private MedicalTopic topic;
    @Column
    private Date date;

}
