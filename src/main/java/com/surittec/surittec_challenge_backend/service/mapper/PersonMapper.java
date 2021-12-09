package com.surittec.surittec_challenge_backend.service.mapper;

import com.surittec.surittec_challenge_backend.model.Person;
import com.surittec.surittec_challenge_backend.service.dto.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

// Tried to use DTO, but it's broken somehow
@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person personDTOToPerson(PersonDTO personDTO);

    void updatePersonFromPersonDTO(PersonDTO personDTO, @MappingTarget Person person);
}