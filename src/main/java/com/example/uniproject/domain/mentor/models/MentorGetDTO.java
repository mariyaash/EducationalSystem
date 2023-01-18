package com.example.uniproject.domain.mentor.models;

import com.example.uniproject.domain.account.models.AccountGetDTO;

public record MentorGetDTO(
        Long id,
        String rank,
        AccountGetDTO accountGetDTO
) {
}
