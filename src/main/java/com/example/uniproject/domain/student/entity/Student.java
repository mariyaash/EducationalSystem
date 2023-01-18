package com.example.uniproject.domain.student.entity;

import com.example.uniproject.domain.account.entity.Account;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "student_level",nullable = false)
    @Pattern(regexp = "^([a-zA-Z-]){3,}$", message = "Invalid input for student level field")
    private String level;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account", referencedColumnName = "id", updatable = false, unique = true)
    private Account account;

    public Student(Long id, String name, Account account) {
        this.id = id;
        this.level = name;
        this.account = account;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
