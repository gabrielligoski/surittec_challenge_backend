package com.surittec.surittec_challenge_backend.model.mapper;

import com.surittec.surittec_challenge_backend.model.Person;
import com.surittec.surittec_challenge_backend.model.dto.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person personDTOToPerson(PersonDTO personDTO);

    void updatePersonFromPersonDTO(PersonDTO personDTO, @MappingTarget Person person);
}