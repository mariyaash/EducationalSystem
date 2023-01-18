package com.example.uniproject.infrastructure.mappers;

import com.example.uniproject.domain.mentor.entity.Mentor;
import com.example.uniproject.domain.mentor.models.MentorCreateDTO;
import com.example.uniproject.domain.mentor.models.MentorGetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MentorMapper {
    @Mapping(target = "account", source = "accountCreateDTO" )
    Mentor mentorCreateDTOToMentor(MentorCreateDTO mentorCreateDTO);
    @Mapping(target = "accountGetDTO",source = "account")
    MentorGetDTO mentorToMentorGetDTO(Mentor mentor);
    void update(@MappingTarget Mentor mentor,MentorCreateDTO mentorCreateDTO);

}
