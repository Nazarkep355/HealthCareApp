package com.example.healthcareapp.util;

import com.example.healthcareapp.dto.ResponseMessage;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ErrorCatcher {
public static  ResponseEntity catchException(Supplier supplier){
    try {
        return ResponseEntity.ok(supplier.get());

    } catch (IllegalArgumentException e) {
        return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON)
                .body(ResponseMessage.customMessage(e.getMessage()));
    }
}
}
