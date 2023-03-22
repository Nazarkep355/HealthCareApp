package com.example.healthcareapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "subjects")
public class AnalysisSubject {

    @Id
    private Long id;
    @ManyToOne
    private MedicalTopic topic;
    @Column
    private String name;


}
