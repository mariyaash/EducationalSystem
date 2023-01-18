package com.example.uniproject.domain.mentor.entity;

import com.example.uniproject.domain.account.entity.Account;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@Entity
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "mentor_rank", nullable = false, unique = true)
    @Pattern(regexp = "^([a-z A-Z-]){3,}$", message = "Invalid input for rank field")
    private String rank;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account", referencedColumnName = "id", updatable = false, unique = true)
    private Account account;

    public Mentor(Long id, String rank, Account account) {
        this.id = id;
        this.rank = rank;
        this.account = account;
    }

    public Mentor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
