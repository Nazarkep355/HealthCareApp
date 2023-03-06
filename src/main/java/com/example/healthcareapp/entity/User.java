package com.example.healthcareapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="users")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String firstName;
    @Column
    private String secondName;
    @Column
    private UserRole role;
    @OneToOne(mappedBy = "user")
    private MedicalCard medicalCard;
}
