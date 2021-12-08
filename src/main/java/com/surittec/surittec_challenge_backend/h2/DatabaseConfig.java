package com.surittec.surittec_challenge_backend.h2;

import com.surittec.surittec_challenge_backend.model.Person;
import com.surittec.surittec_challenge_backend.model.User;
import com.surittec.surittec_challenge_backend.repository.PersonRepository;
import com.surittec.surittec_challenge_backend.repository.UserRepository;

public class DatabaseConfig {

    public DatabaseConfig(PersonRepository personRepository, UserRepository userRepository) {
        String[] names = {"Billy ", "Pedro ", "Coral ", "Kadie ", "Kason ", "Markus ",
                "Florence ", "Yousef ", "Malikah ", "Joe "};
        String[] surnames = {"Graham", "Knight", "Manning", "Butler", "Cortes", "Hirst",
                "Lindsay", "Ashley", "Chandler", "Butt"};
        String[] addresses = {"Englewood Colorado", "Gracey Kentucky", "Reno Nevada",
                "City Of Commerce California", "Blanco Texas", "Solway Minnesota",
                "Indianapolis Indiana", "LERONA West Virginia", "Mobile Alabama", "Jacksonville Florida"};
        String[] emails = {"bsalsfeerr@noisemails.com", "alecsdjk@txtiu.site", "peshobmf@myhavyrtda.com",
                "msgrnthumb457@hansongu.com", "marimar563@packiu.com", "macbookcore@ttmgss.com",
                "mo2z@italiavendecommerciali.online", "htcevolh@ichstet.com", "jujubafp@nakiuha.com",
                "metaljacket53@ottappmail.com"};

        for (int i = 0; i < 50; i++) {
            String name = String.format("%s%s", names[(int) (Math.random() * 10)], surnames[(int) (Math.random() * 10)]);
            Long cpf = 1L + (long) (Math.random() * (999_999_999_99L - 1L));
            String address = String.format("%s", addresses[(int) (Math.random() * 10)]);
            Long phone = 1L + (long) (Math.random() * (99_9_9999_9999L - 1L));
            String email = String.format("%s", emails[(int) (Math.random() * 10)]);

            Person person = new Person(name, cpf, address, phone, email);

            personRepository.save(person);
        }

        User commonUser = new User("comum", "123456", "ROLE_USER");
        User adminUser = new User("admin", "123456", "ROLE_ADMIN");

        userRepository.save(commonUser);
        userRepository.save(adminUser);
    }

}
