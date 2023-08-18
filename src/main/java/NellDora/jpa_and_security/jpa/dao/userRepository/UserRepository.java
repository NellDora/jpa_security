package NellDora.jpa_and_security.jpa.dao.userRepository;

import NellDora.jpa_and_security.jpa.dto.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Repository
@Transactional
public class UserRepository {

    private final EntityManager manager;

     //JPA는 트랜잭션 안에서 동작함.
    public User save(User user){
        user.setLevel(1);
        user.setEXP(0);
        manager.persist(user);
        return user;
    }

    public void delete(User user){ //말그대로 삭제 기능인데 remove시 Entity 객체를 넘겨주고 삭제
        manager.remove(user); // ->등록한 @ID를 넘겨서 삭제함
    }

    public User findById(String id){
        User user =manager.find(User.class,id);
        return user;
    }

    public User update(String id,User user){
        User findUser = manager.find(User.class,id);
        return null;

    }

}
