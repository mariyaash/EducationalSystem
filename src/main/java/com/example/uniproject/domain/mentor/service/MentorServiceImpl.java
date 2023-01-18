package com.example.uniproject.domain.mentor.service;

import com.example.uniproject.domain.account.models.AccountCreateDTO;
import com.example.uniproject.domain.mentor.entity.Mentor;
import com.example.uniproject.domain.mentor.models.MentorCreateDTO;
import com.example.uniproject.domain.mentor.models.MentorGetDTO;
import com.example.uniproject.domain.mentor.repository.MentorRepository;
import com.example.uniproject.infrastructure.mappers.MentorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MentorServiceImpl implements MentorService {
    private final MentorRepository mentorRepository;
    private final MentorMapper mentorMapper;

    @Autowired
    public MentorServiceImpl(MentorRepository mentorRepository, MentorMapper mentorMapper) {
        this.mentorRepository = mentorRepository;
        this.mentorMapper = mentorMapper;
    }

    @Override
    public MentorGetDTO create(MentorCreateDTO mentorCreateDTO) {
        Mentor mentor = mentorMapper.mentorCreateDTOToMentor(mentorCreateDTO);
        Mentor createdMentor = mentorRepository.save(mentor);
        return mentorMapper.mentorToMentorGetDTO(createdMentor);
    }

    @Override
    public MentorGetDTO get(Long id) {
        Mentor mentor = mentorRepository.findById(id)
                .orElseThrow();
        return mentorMapper.mentorToMentorGetDTO(mentor);
    }

    @Override
    public MentorGetDTO update(Long id, MentorCreateDTO mentorCreateDTO) {
        Mentor mentor = mentorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("This id of mentor does not exist."));
        if (!mentorCreateDTO.accountCreateDTO().email().equals(mentor.getAccount().getEmail())) {
            throw new RuntimeException("You are not allowed to change the email because it is unique.");
        } else {
            mentorMapper.update(mentor, mentorCreateDTO);
            Mentor updatedMentor = mentorRepository.save(mentor);
            return mentorMapper.mentorToMentorGetDTO(updatedMentor);
        }
    }

    @Override
    public void delete(Long id) {
        if(!mentorRepository.existsById(id)){
            throw new RuntimeException("There is no existing id to delete");
        }
        else{
            mentorRepository.deleteById(id);
        }
    }
}
