package com.example.healthcareapp.service;

import com.example.healthcareapp.dto.Models.AnalysisModel;
import com.example.healthcareapp.dto.Models.CreateRecordModel;
import com.example.healthcareapp.dto.Models.SubjectModel;
import com.example.healthcareapp.entity.*;
import com.example.healthcareapp.repos.*;
import com.example.healthcareapp.util.ErrorCatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnalysesService {
    @Autowired
    private ModelMapperMyImpl modelMapperMy;
    @Autowired
    private AnalysisRepository analysisRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private MedicalTopicRepository topicRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    public Page<AnalysisModel> getAllAnalysisOfUser(Long id, Pageable pageable) {
        Optional<User> user = userRepository.findById(id);
        Page<Analysis> analysisPage = analysisRepository.findAllByUser(user
                .orElseThrow(() -> new IllegalArgumentException("User not found")), pageable);
        List<AnalysisModel> models = modelMapperMy.listOfModels(analysisPage.getContent(), AnalysisModel.class);
        return new PageImpl<>(models, pageable, analysisPage.getTotalPages());

    }

    public AnalysisModel scheduleAnalysis(AnalysisModel analysisModel) {
        Analysis analysis = modelMapperMy.mapClass(analysisModel, Analysis.class);
        analysis.setAuthor(doctorRepository.findById(analysis.getAuthor().getId())
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found")));
        analysis.setSubject(subjectRepository.findById(analysis.getSubject().getId())
                .orElseThrow(() -> new IllegalArgumentException("Subject not found")));
        analysis.setUser(userRepository.findById(analysis.getUser().getId())
                .orElseThrow(() -> new IllegalArgumentException("User not found")));
        analysis = analysisRepository.save(analysis);
        return modelMapperMy.mapClass(analysis, AnalysisModel.class);
    }

    public Page<SubjectModel> getAllSubjects(Pageable pageable) {
        Page<AnalysisSubject> subjects = subjectRepository.findAll(pageable);
        return new PageImpl<>(modelMapperMy
                .listOfModels(subjects.getContent(), SubjectModel.class)
                , pageable, subjects.getTotalPages());
    }
}
