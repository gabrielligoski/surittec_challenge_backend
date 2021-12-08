package com.surittec.surittec_challenge_backend.repository;

import com.surittec.surittec_challenge_backend.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
