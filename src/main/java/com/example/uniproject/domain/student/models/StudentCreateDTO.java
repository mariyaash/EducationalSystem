package com.example.uniproject.domain.student.models;

import com.example.uniproject.domain.account.models.AccountCreateDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

public record StudentCreateDTO(
        @Pattern(regexp = "^([a-zA-Z-]){3,}$", message = "Invalid input for name field")
        String level,
        @Valid
        AccountCreateDTO accountCreateDTO
) {
}
