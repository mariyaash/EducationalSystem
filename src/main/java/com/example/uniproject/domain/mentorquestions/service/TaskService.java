package com.example.uniproject.domain.mentorquestions.service;

import com.example.uniproject.domain.mentorquestions.models.TaskCreateDTO;
import com.example.uniproject.domain.mentorquestions.models.TaskGetDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {
    TaskGetDTO create(TaskCreateDTO taskCreateDTO);

    TaskGetDTO getById(Long id);

    Page<TaskGetDTO> getAll(Pageable pageable);

    TaskGetDTO update(Long id, TaskCreateDTO taskCreateDTO);
}
