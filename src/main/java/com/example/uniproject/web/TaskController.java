package com.example.uniproject.web;

import com.example.uniproject.domain.mentorquestions.models.TaskCreateDTO;
import com.example.uniproject.domain.mentorquestions.models.TaskGetDTO;
import com.example.uniproject.domain.mentorquestions.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/task")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskGetDTO> create(@Valid @RequestBody TaskCreateDTO taskCreateDTO) {
        return ResponseEntity.ok(taskService.create(taskCreateDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskGetDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Page<TaskGetDTO>> get(@PageableDefault(size = 11) Pageable pageable) {
        return ResponseEntity.ok(taskService.getAll(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskGetDTO> update(Long id, TaskCreateDTO taskCreateDTO) {
        return ResponseEntity.ok(taskService.update(id, taskCreateDTO));
    }

}
