package com.example.uniproject.domain.mentor.models;

import com.example.uniproject.domain.account.models.AccountCreateDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record MentorCreateDTO(

        @Pattern(regexp = "^([a-z A-Z-]){3,}$", message = "Invalid input for name field")
        String rank,

        @Valid
        AccountCreateDTO accountCreateDTO
) {
}
