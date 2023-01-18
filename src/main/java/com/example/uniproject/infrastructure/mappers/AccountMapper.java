package com.example.uniproject.infrastructure.mappers;

import com.example.uniproject.domain.account.entity.Account;
import com.example.uniproject.domain.account.models.AccountCreateDTO;
import com.example.uniproject.domain.account.models.AccountGetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    Account accountCreateDTOToAccount(AccountCreateDTO accountCreateDTO);

    AccountGetDTO accountToAccountGetDTO(Account account);

    void update(@MappingTarget Account account, AccountCreateDTO createDTO);

}