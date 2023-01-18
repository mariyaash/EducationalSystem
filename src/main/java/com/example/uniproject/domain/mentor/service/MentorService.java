package com.example.uniproject.domain.mentor.service;

import com.example.uniproject.domain.account.models.AccountCreateDTO;
import com.example.uniproject.domain.mentor.models.MentorCreateDTO;
import com.example.uniproject.domain.mentor.models.MentorGetDTO;

public interface MentorService {
    MentorGetDTO create(MentorCreateDTO mentorCreateDTO);

    MentorGetDTO get(Long id);

    MentorGetDTO update(Long id, MentorCreateDTO mentorCreateDTO);

    void delete(Long id);
}
