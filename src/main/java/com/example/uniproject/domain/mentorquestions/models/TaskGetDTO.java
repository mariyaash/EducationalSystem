package com.example.uniproject.domain.mentorquestions.models;


import com.example.uniproject.domain.student.entity.Student;

import java.util.List;

public record TaskGetDTO(
         Long id,
         String question,
         Long mentorId,
         List<Student>student
) {
}
