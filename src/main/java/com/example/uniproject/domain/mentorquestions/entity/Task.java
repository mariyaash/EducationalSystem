package com.example.uniproject.domain.mentorquestions.entity;

import com.example.uniproject.domain.mentor.entity.Mentor;
import com.example.uniproject.domain.student.entity.Student;
import jakarta.persistence.*;

import java.util.List;

@Table(name = "task")
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question", nullable = false)
    private String question;

    @Column(name = "answer", nullable = false)
    private String answer;

    @ManyToOne
    @JoinColumn(name = "mentor_id", referencedColumnName = "id", nullable = false, unique = true)
    private Mentor mentor;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    private List<Student> student;

    public Task(Long id, String question, String answer, Mentor mentor) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.mentor = mentor;
    }

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public void addStudent(Student students) {
        student.add(students);
    }
}
