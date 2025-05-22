package com.cozy.command.core.model.payload.internal.field;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterUserRequest {
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
