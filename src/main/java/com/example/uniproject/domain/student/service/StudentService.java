package com.example.uniproject.domain.student.service;

import com.example.uniproject.domain.student.models.StudentCreateDTO;
import com.example.uniproject.domain.student.models.StudentGetDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    StudentGetDTO create(StudentCreateDTO studentCreateDTO);

    StudentGetDTO findById(Long id);

    Page<StudentGetDTO> getAll(Pageable pageable);

    StudentGetDTO update(Long id, StudentCreateDTO studentCreateDTO);

    void delete(Long id);
}
