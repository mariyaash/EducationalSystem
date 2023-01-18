package com.example.uniproject.domain.student.repository;

import com.example.uniproject.domain.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
