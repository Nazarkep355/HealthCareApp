package com.example.healthcareapp.repos;

import com.example.healthcareapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
