package com.example.healthcareapp.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class ResponseMessage {
    Date timestamp;
    String Message;
    int status;
    String error;
    List<Error> errors;
    public static ResponseMessage customMessage(String message){
        ResponseMessage rm = builder().timestamp(Date.from(Instant.now()))
                .status(400)
                .error("Bad Request")
                .errors(List.of(Error.builder()
                        .codes(List.of(message))
                        .build()))
                .build();
        return rm;
    }
    public static ResponseMessage badPassword() {
        ResponseMessage rm = builder().timestamp(Date.from(Instant.now()))
                .status(400)
                .error("Bad Request")
                .errors(List.of(Error.builder()
                        .codes(List.of("Password"))
                        .build()))
                .build();
        return rm;
    }
    public static ResponseMessage userIsExists(){
        ResponseMessage rm = builder().timestamp(Date.from(Instant.now()))
                .status(400)
                .error("Bad Request")
                .errors(List.of(Error.builder()
                        .codes(List.of("User exists"))
                        .build()))
                .build();
        return rm;
    }

    @Builder
    @Data
    static class Error {
        List<String> codes;
    }
}
