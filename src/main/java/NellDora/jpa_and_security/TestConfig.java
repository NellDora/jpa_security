package NellDora.jpa_and_security;

import NellDora.jpa_and_security.dto.Country;
import NellDora.jpa_and_security.dto.Gender;
import NellDora.jpa_and_security.dto.User;
import NellDora.jpa_and_security.dto.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestConfig {

    private final UserRepository repository;


    @EventListener
    public void createUser(){
        User user1 = new User("Logan",33, Gender.MALE, Country.AMERICA);
        User user2 = new User("Noah",24, Gender.MALE, Country.AMERICA);
        User user3 = new User("Lucas",20, Gender.MALE, Country.AMERICA);
        repository.save(user1);
        repository.save(user2);
        repository.save(user3);
    }


}
