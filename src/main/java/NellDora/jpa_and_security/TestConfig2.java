package NellDora.jpa_and_security;

import NellDora.jpa_and_security.jpa.dto.user.Country;
import NellDora.jpa_and_security.jpa.dto.user.Gender;
import NellDora.jpa_and_security.jpa.dto.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Component
@Slf4j
@RequiredArgsConstructor
@Transactional
public class TestConfig2 {

    private final EntityManager manager;

    //양방향 연관관계 테스트
    @EventListener(ApplicationReadyEvent.class)
    public void ManyToOneTest() {
        Country country1 = new Country(101,"KOREA");
        manager.persist(country1);

        User user1 = new User("LionKing","Dalsu",22, Gender.MALE);
        user1.setCountry(country1);
        user1.setLevel(1);
        user1.setEXP(0);
        manager.persist(user1);
    }
}
