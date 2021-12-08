package com.surittec.surittec_challenge_backend.web.rest;

import com.surittec.surittec_challenge_backend.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserResource {

    private final PersonRepository personRepository;

    public UserResource(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> activateAccount(@PathVariable Long id) {
        System.out.printf("REST request to get Person : {%s}%n", id);



        return ResponseEntity.status(HttpStatus.OK).body(personRepository.findById(id));
    }

}
