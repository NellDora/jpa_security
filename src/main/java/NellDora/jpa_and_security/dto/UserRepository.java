package NellDora.jpa_and_security.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@RequiredArgsConstructor
@Repository
public class UserRepository {

    private final EntityManager manager;

    @Transactional //JPA는 트랜잭션 안에서 동작함.
    public User save(User user){
        manager.persist(user);
        return user;
    }
}
