package com.example.healthcareapp.dto.Models;

import com.example.healthcareapp.entity.UserRole;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {

    public Long id;
    private String email;
    private String firstName;
    private String secondName;
    private UserRole role;

}
