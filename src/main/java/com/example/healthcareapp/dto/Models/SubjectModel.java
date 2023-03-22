package com.example.healthcareapp.dto.Models;

import com.example.healthcareapp.entity.MedicalTopic;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectModel {
    private Long id;
    private MedicalTopic topic;
    private String name;
}
