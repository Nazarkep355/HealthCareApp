package com.example.healthcareapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="analyses")
public class Analysis {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String subject;
    @Column
    private String result;
    @Column
    private Date date;
    @ManyToOne
    @JoinColumn(name="author_id")
    private Doctor author;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name="topic_id")
    private MedicalTopic topic;




}
