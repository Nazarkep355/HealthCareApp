package com.example.healthcareapp;

import com.example.healthcareapp.service.DataGenerator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HealthCareAppApplication implements CommandLineRunner {
    @Autowired
    private DataGenerator dataGenerator;

    public static void main(String[] args) {
        SpringApplication.run(HealthCareAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    dataGenerator.generate();
    }
}
