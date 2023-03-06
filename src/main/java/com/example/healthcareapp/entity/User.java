package com.example.healthcareapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
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
    @Email
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
