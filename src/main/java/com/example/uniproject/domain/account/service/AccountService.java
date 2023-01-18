package com.example.uniproject.domain.account.service;

import com.example.uniproject.domain.account.models.AccountCreateDTO;
import com.example.uniproject.domain.account.models.AccountGetDTO;

public interface AccountService {
    AccountGetDTO create(AccountCreateDTO accountCreateDTO);
}
