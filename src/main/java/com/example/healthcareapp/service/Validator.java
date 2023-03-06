package com.example.healthcareapp.service;

import com.example.healthcareapp.dto.ResponseMessage;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class Validator {
    final static private String passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";

    public Optional<ResponseEntity> validatePassword(String password) {
        if (password!=null&&Pattern.compile(passwordPattern).matcher(password).matches()) {
            return Optional.empty();
        } else {
            ResponseEntity responseEntity = ResponseEntity
                    .badRequest().contentType(MediaType.APPLICATION_JSON)
                    .body(ResponseMessage.badPassword());
            return Optional.of(responseEntity);
        }
    }
}
