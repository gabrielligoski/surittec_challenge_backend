package com.surittec.surittec_challenge_backend.repository;

import java.util.List;

import com.surittec.surittec_challenge_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// configured user's database, for register but wasn't necessary
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUser(String user);
}
