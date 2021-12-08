package com.surittec.surittec_challenge_backend.web.rest;

import java.util.List;
import java.util.Optional;

import com.surittec.surittec_challenge_backend.model.Person;
import com.surittec.surittec_challenge_backend.repository.PersonRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Object> getAllPersons(){
        System.out.printf("REST request to get all Persons");
        List<Person> person = personRepository.findAll();

        if(person.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

    @PostMapping("/person")
    public ResponseEntity<Object> getAllPersons(){
        System.out.printf("REST request to get all Persons");
        List<Person> person = personRepository.findAll();

        if(person.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

}
