package com.surittec.surittec_challenge_backend;

import com.surittec.surittec_challenge_backend.h2.DatabaseConfig;
import com.surittec.surittec_challenge_backend.model.Person;
import com.surittec.surittec_challenge_backend.repository.PersonRepository;
import com.surittec.surittec_challenge_backend.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SurittecChallengeBackendApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(SurittecChallengeBackendApplication.class, args);
        PersonRepository personRepository =
                configurableApplicationContext.getBean(PersonRepository.class);
        UserRepository userRepository =
                configurableApplicationContext.getBean(UserRepository.class);
        new DatabaseConfig(personRepository, userRepository);
    }
}
