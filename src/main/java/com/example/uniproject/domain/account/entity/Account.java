package com.example.uniproject.domain.account.entity;

import com.example.uniproject.infrastructure.security.constraint.ValidPassword;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import javax.management.relation.Role;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Email(message = "Email is mandatory")
    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "full_name", nullable = false)
    @Pattern(regexp = "^([a-z A-Z-]){3,}$", message = "Invalid input for name field")
    private String fullName;

    @Column(nullable = false)
    @ValidPassword
    private String password;

    public Account(Long id, String email, String fullName, String password) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.password = password;
    }

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


