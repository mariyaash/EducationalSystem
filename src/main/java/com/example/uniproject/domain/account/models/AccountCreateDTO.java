package com.example.uniproject.domain.account.models;

import com.example.uniproject.infrastructure.security.constraint.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record AccountCreateDTO(
        @Email(message = "Email is mandatory")
        String email,

        @Pattern(regexp = "^([a-z A-Z-]){3,}$", message = "Invalid input for name field")
        String fullName,

        @ValidPassword
        String password
        ) {
}
