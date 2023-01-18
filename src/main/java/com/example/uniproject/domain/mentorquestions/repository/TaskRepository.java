package com.example.uniproject.domain.mentorquestions.repository;

import com.example.uniproject.domain.mentorquestions.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
