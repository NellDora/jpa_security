package NellDora.jpa_and_security;

import NellDora.jpa_and_security.jpa.dto.user.Country;
import NellDora.jpa_and_security.jpa.dto.user.Gender;
import NellDora.jpa_and_security.jpa.dto.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class TestConfig2 {

    private final EntityManager manager;


    //양방향 연관관계 테스트
        @Transactional
        @Bean
        public void ManyToOneTest() {
            Country country1 = new Country(101,"KOREA");
            Country country2 = new Country(201, "AMERICA");
            manager.persist(country1);
            manager.persist(country2);

            User user1 = new User("Venom","Dalsu",24, Gender.MALE);
            user1.setCountry(country1);
            user1.setLevel(1);
            user1.setEXP(0);

            User user2 = new User("Eagle","Gwan",28, Gender.FEMALE);
            user2.setCountry(country2);
            user2.setLevel(1);
            user2.setEXP(0);

            User user3 = new User("Turtle","Jinsu",20, Gender.MALE);
            user3.setCountry(country1);
            user3.setLevel(1);
            user3.setEXP(0);

            User user4 = new User("Drake","Haein",24, Gender.FEMALE);
            user4.setCountry(country1);
            user4.setLevel(1);
            user4.setEXP(0);

            User user5= new User ("Mantra", "Karmen",30,Gender.FEMALE);
            user5.setCountry(country2);
            user5.setLevel(1);
            user5.setEXP(0);

            manager.persist(user1);
            manager.persist(user2);
            manager.persist(user3);
            manager.persist(user4);
            manager.persist(user5);
    }
        //@Transactional
        //@Bean
        public void ManyToOneTest2() {
            User findUser = manager.find(User.class,"Venom");
            Country findCountry = findUser.getCountry();
            findCountry.getName();

            int usersSize=findCountry.getUserList().size();
            log.info("해당 국가에 소속된 인원 = {} 명", usersSize);

            List<User> users = findCountry.getUserList();
            for(User user : users){
                System.out.println("정보 출력");
                System.out.println("출력 ID = " + user.getUserId()+", 이름 = "+ user.getUserName()+
                        ", 나라 정보 = "+ user.getCountry().getName()+". ");
            }

   }


}
