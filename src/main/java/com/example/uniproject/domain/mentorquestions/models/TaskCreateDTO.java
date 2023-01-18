package com.example.uniproject.domain.mentorquestions.models;

public record TaskCreateDTO(
        String question,
        String answer,
        Long mentorId
) {
}
