package com.example.uniproject.infrastructure.mappers;

import com.example.uniproject.domain.mentor.service.MentorService;
import com.example.uniproject.domain.mentorquestions.entity.Task;
import com.example.uniproject.domain.mentorquestions.models.TaskCreateDTO;
import com.example.uniproject.domain.mentorquestions.models.TaskGetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = MentorService.class)
public interface TaskMapper {
    @Mapping(source = "mentorId", target = "mentor.id")
    Task taskCreateDTOToTask(TaskCreateDTO taskCreateDTO);

    @Mapping(source = "mentor.id", target = "mentorId")
    TaskGetDTO taskToTaskGetDTO(Task task);

    void update(@MappingTarget Task task, TaskCreateDTO taskCreateDTO);
}
