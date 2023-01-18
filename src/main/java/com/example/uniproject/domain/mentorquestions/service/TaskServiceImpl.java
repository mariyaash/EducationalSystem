package com.example.uniproject.domain.mentorquestions.service;

import com.example.uniproject.domain.mentorquestions.entity.Task;
import com.example.uniproject.domain.mentorquestions.models.TaskCreateDTO;
import com.example.uniproject.domain.mentorquestions.models.TaskGetDTO;
import com.example.uniproject.domain.mentorquestions.repository.TaskRepository;
import com.example.uniproject.infrastructure.mappers.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskGetDTO create(TaskCreateDTO taskCreateDTO) {
        Task task = taskMapper.taskCreateDTOToTask(taskCreateDTO);
        Task createdTask = taskRepository.save(task);
        return taskMapper.taskToTaskGetDTO(createdTask);
    }

    @Override
    public TaskGetDTO getById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("There is no such task"));
        return taskMapper.taskToTaskGetDTO(task);
    }

    @Override
    public Page<TaskGetDTO> getAll(Pageable pageable) {
        return taskRepository.findAll(pageable).map(taskMapper::taskToTaskGetDTO);
    }

    @Override
    public TaskGetDTO update(Long id, TaskCreateDTO taskCreateDTO) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("There is no existing id."));
        if (!taskCreateDTO.mentorId().equals(task.getMentor().getId())) {
            throw new RuntimeException("You are not able to change the mentor id . ");
        } else {
            taskMapper.update(task, taskCreateDTO);
            Task updatedTask = taskRepository.save(task);
            return taskMapper.taskToTaskGetDTO(updatedTask);
        }
    }
}
