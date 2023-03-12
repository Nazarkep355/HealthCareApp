package com.example.healthcareapp.controller;

import com.example.healthcareapp.dto.Models.UserModel;
import com.example.healthcareapp.dto.ResponseMessage;
import com.example.healthcareapp.entity.User;
import com.example.healthcareapp.entity.UserRole;
import com.example.healthcareapp.service.UserLoginService;
import com.example.healthcareapp.service.Validator;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@ApiResponses
public class LoginController {
    @Autowired
    private UserLoginService loginService;
    @Autowired
    private Validator validator;


    @PostMapping("/login")
    public ResponseEntity<UserModel> login(String email, String password) {
        // как мне тебе целую модель юзера передать при лонике ?
        Optional<User> userOptional = loginService.login(email,password);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(401).build();
        }
         return ResponseEntity.ok(MapToModel(userOptional.get()));
    }

    @PostMapping("/register")
    public ResponseEntity register(@Valid User user,User user1) {
        Optional<ResponseEntity> reOptional = validator
                .validatePassword(user.getPassword());
        if (reOptional.isPresent()) {
            return reOptional.get();
        }
        Optional<User> userOptional = loginService.register(user);
        if(userOptional.isEmpty()){
            return ResponseEntity
                    .badRequest().contentType(MediaType.APPLICATION_JSON)
                    .body(ResponseMessage.userIsExists());
        }
        ResponseEntity<User> responseEntity =
                ResponseEntity.of(userOptional);
        return responseEntity;
    }

    private UserModel MapToModel (User user) {
        ModelMapper modelMapper = new ModelMapper();
        // map source object to destination object
        UserModel dest = modelMapper.map(user, UserModel.class);
        return dest;
    };
}
