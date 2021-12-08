package com.surittec.surittec_challenge_backend.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.surittec.surittec_challenge_backend.model.Person;
import com.surittec.surittec_challenge_backend.model.dto.PersonDTO;
import com.surittec.surittec_challenge_backend.model.mapper.PersonMapper;
import com.surittec.surittec_challenge_backend.repository.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class PersonResource {

    private final PersonRepository personRepository;

    public PersonResource(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Object> getPerson(@PathVariable Long id) {
        System.out.printf("REST request to get Person : {%s}%n", id);
        Optional<Person> person = personRepository.findById(id);
        if(person.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

    @GetMapping("/person")
    public ResponseEntity<List<Person>> getAllPersons(){
        System.out.print("REST request to get all Persons");

        return ResponseEntity.ok().body(personRepository.findAll());
    }

    @PostMapping("/person")
    public ResponseEntity<Person> createPerson(@Valid @RequestBody PersonDTO person) throws URISyntaxException {
        System.out.print("REST request to post Person");

        System.out.print(person.getName());
        var result = personRepository.save(PersonMapper.INSTANCE.personDTOToPerson(person));
        System.out.print(result.getName());

        return ResponseEntity.created(new URI("/api/person/" + result.getId()))
                .body(result);
    }

}
