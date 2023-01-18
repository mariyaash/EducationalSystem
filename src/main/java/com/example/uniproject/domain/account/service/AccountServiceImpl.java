package com.example.uniproject.domain.account.service;

import com.example.uniproject.domain.account.entity.Account;
import com.example.uniproject.domain.account.models.AccountCreateDTO;
import com.example.uniproject.domain.account.models.AccountGetDTO;
import com.example.uniproject.domain.account.repository.AccountRepository;
import com.example.uniproject.infrastructure.mappers.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceImpl implements AccountService {
    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountMapper accountMapper, AccountRepository accountRepository) {
        this.accountMapper = accountMapper;
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountGetDTO create(AccountCreateDTO accountCreateDTO) {
            Account account = accountMapper.accountCreateDTOToAccount(accountCreateDTO);
            Account createdAccount = accountRepository.save(account);
            return accountMapper.accountToAccountGetDTO(createdAccount);
        }

    }
