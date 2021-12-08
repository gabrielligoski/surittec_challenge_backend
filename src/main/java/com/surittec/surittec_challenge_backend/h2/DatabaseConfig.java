package com.surittec.surittec_challenge_backend.h2;

import java.util.Arrays;
import java.util.List;

import com.surittec.surittec_challenge_backend.model.Address;
import com.surittec.surittec_challenge_backend.model.Person;
import com.surittec.surittec_challenge_backend.model.Phone;
import com.surittec.surittec_challenge_backend.model.User;
import com.surittec.surittec_challenge_backend.repository.PersonRepository;
import com.surittec.surittec_challenge_backend.repository.UserRepository;

import static com.surittec.surittec_challenge_backend.model.enumeration.PhoneType.PERSONAL;
import static com.surittec.surittec_challenge_backend.model.enumeration.PhoneType.WORK;

public class DatabaseConfig {

    public DatabaseConfig(PersonRepository personRepository, UserRepository userRepository) {
        String[] names = {"Billy ", "Pedro ", "Coral ", "Kadie ", "Kason ", "Markus ",
                "Florence ", "Yousef ", "Malikah ", "Joe "};
        String[] surnames = {"Graham", "Knight", "Manning", "Butler", "Cortes", "Hirst",
                "Lindsay", "Ashley", "Chandler", "Butt"};
        String[] zips = {"35181711", "78933535", "86015170", "86015170", "38443178"};
        String[] streets = {"Englewood Colorado", "Gracey Kentucky", "Reno Nevada",
                "City Of Commerce California", "Blanco Texas", "Solway Minnesota",
                "Indianapolis Indiana", "LERONA West Virginia", "Mobile Alabama", "Jacksonville Florida"};
        String[] states = {"MG", "DF", "SP", "AC", "RS"};
        String[] district = {"distrito1", "distrito2", "distrito3", "distrito4", "distrito5"};
        String[] cities = {"São Leopoldo", "Macaé", "Recife", "Belo Horizonte", "Brasília"};
        String[] emails = {"bsalsfeerr@noisemails.com", "alecsdjk@txtiu.site", "peshobmf@myhavyrtda.com",
                "msgrnthumb457@hansongu.com", "marimar563@packiu.com", "macbookcore@ttmgss.com",
                "mo2z@italiavendecommerciali.online", "htcevolh@ichstet.com", "jujubafp@nakiuha.com",
                "metaljacket53@ottappmail.com"};

        for (int i = 0; i < 50; i++) {
            String name = String.format("%s%s", names[(int) (Math.random() * 10)], surnames[(int) (Math.random() * 10)]);
            Long cpf = 1L + (long) (Math.random() * (999_999_999_99L - 1L));

            Address address = new Address(String.format("%s", zips[(int) (Math.random() * 5)]),
                    String.format("%s", streets[(int) (Math.random() * 10)]),
                    String.format("%s", district[(int) (Math.random() * 5)]),
                    String.format("%s", cities[(int) (Math.random() * 5)]),
                    String.format("%s", states[(int) (Math.random() * 5)]));

            String email1 = String.format("%s", emails[(int) (Math.random() * 10)]);
            String email2 = String.format("%s", emails[(int) (Math.random() * 10)]);
            List<String> email = Arrays.asList(email1, email2);
            List<Phone> phone = Arrays.asList(
                    new Phone((1L + (long) (Math.random() * (99_9_9999_9999L - 1L))), PERSONAL),
                    new Phone((1L + (long) (Math.random() * (99_9_9999_9999L - 1L))), WORK));

            Person person = new Person(name, cpf, address, phone, email);

            personRepository.save(person);
        }

        User commonUser = new User("comum", "123456", "ROLE_USER");
        User adminUser = new User("admin", "123456", "ROLE_ADMIN");

        userRepository.save(commonUser);
        userRepository.save(adminUser);
    }
}
