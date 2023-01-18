package com.example.uniproject.domain.account.repository;

import com.example.uniproject.domain.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByEmailAndPassword(String email,String password);

}
