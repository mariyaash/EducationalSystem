package com.example.uniproject.domain.student.service;

import com.example.uniproject.domain.student.entity.Student;
import com.example.uniproject.domain.student.models.StudentCreateDTO;
import com.example.uniproject.domain.student.models.StudentGetDTO;
import com.example.uniproject.domain.student.repository.StudentRepository;
import com.example.uniproject.infrastructure.mappers.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentGetDTO create(StudentCreateDTO studentCreateDTO) {
        Student student = studentMapper.studentCreateDTOToStudent(studentCreateDTO);
        Student createdStudent = studentRepository.save(student);
        return studentMapper.studentToStudentToGetDTO(createdStudent);
    }

    @Override
    public StudentGetDTO findById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("This id of student is no existing"));
        return studentMapper.studentToStudentToGetDTO(student);
    }

    @Override
    public Page<StudentGetDTO> getAll(Pageable pageable) {
        return studentRepository.findAll(pageable).map(studentMapper::studentToStudentToGetDTO);
    }

    @Override
    public StudentGetDTO update(Long id, StudentCreateDTO studentCreateDTO) {
        Student student=studentRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("This id of student is not valid. You are not able to update!"));
        if(!studentCreateDTO.accountCreateDTO().email().equals(student.getAccount().getEmail())){
            throw new RuntimeException("It is not allowed to change the email of student!");
        }else{
            studentMapper.update(student,studentCreateDTO);
            Student createdStudent=studentRepository.save(student);
            return studentMapper.studentToStudentToGetDTO(createdStudent);
        }
    }

    @Override
    public void delete(Long id) {
        if(!studentRepository.existsById(id)){
            throw new RuntimeException("There is no existing id to delete");
        }else{
            studentRepository.deleteById(id);
        }
    }

}
