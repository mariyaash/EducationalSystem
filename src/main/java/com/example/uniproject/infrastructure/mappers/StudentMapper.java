package com.example.uniproject.infrastructure.mappers;

import com.example.uniproject.domain.student.entity.Student;
import com.example.uniproject.domain.student.models.StudentCreateDTO;
import com.example.uniproject.domain.student.models.StudentGetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(target = "account",source = "accountCreateDTO")
    Student studentCreateDTOToStudent(StudentCreateDTO studentCreateDTO);
    @Mapping(target = "accountGetDTO",source = "account")
    StudentGetDTO studentToStudentToGetDTO(Student student);
    void update(@MappingTarget Student student,StudentCreateDTO studentCreateDTO);
}
