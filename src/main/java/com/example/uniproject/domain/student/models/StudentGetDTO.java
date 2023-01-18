package com.example.uniproject.domain.student.models;

import com.example.uniproject.domain.account.models.AccountGetDTO;

public record StudentGetDTO(Long id,
                            String level,
                            AccountGetDTO accountGetDTO) {
}
