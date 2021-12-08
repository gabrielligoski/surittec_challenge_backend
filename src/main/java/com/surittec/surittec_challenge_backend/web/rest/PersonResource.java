package com.surittec.surittec_challenge_backend.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import com.surittec.surittec_challenge_backend.model.Person;
import com.surittec.surittec_challenge_backend.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonResource {

    private final PersonRepository personRepository;

    public PersonResource(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/person/{id}")
    public ResponseEntity<Object> getPerson(@PathVariable Long id) {
        System.out.printf("REST request to get a Person : {%s}%n", id);
        Optional<Person> person = personRepository.findById(id);
        if (person.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/person")
    public ResponseEntity<List<Person>> getAllPersons() {
        System.out.print("REST request to get all Persons");

        return ResponseEntity.ok().body(personRepository.findAll());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/person")
    public ResponseEntity<Person> createPerson(@Valid @RequestBody Person person) throws URISyntaxException {
        System.out.print("REST request to create Person");
        var result = personRepository.save(person);

        return ResponseEntity.created(new URI("/api/person/" + result.getId()))
                .body(result);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@Valid @RequestBody Person person) throws URISyntaxException {
        System.out.print("REST request to update a Person");
        var result = personRepository.save(person);
        if (result.getId() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        if (personRepository.findById(person.getId()).isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        personRepository.findById(person.getId()).map(p -> {
            p.setAddress(person.getAddress());
            p.setCpf(person.getCpf());
            p.setEmail(person.getEmail());
            p.setName(person.getName());
            p.setPhone(person.getPhone());
            return null;
        });
        return ResponseEntity.created(new URI("/api/person/" + result.getId()))
                .body(result);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/person/{id}")
    void deleteEmployee(@PathVariable Long id) {
        System.out.print("REST request to delete a Person");
        personRepository.deleteById(id);
    }
}
