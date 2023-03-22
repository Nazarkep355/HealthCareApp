package com.example.healthcareapp.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.security.auth.Subject;
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
    @ManyToOne
    @JoinColumn(name ="subject")
    private AnalysisSubject subject;
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




}
