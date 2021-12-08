package com.surittec.surittec_challenge_backend.repository;

import java.util.List;

import com.surittec.surittec_challenge_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUser(String user);
}
