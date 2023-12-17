package NellDora.jpa_and_security.security.repository;

import NellDora.jpa_and_security.jpa.dto.user.User;
import NellDora.jpa_and_security.security.domain.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
@Slf4j
public class JpaMemberRepository implements MemberRepository {

    private EntityManager em;
    private JPAQueryFactory query;

    public JpaMemberRepository(EntityManager em){
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    public void save(Member member){
        em.persist(member);
    }

    @Override
    public Member findById(String memberId) {
        return em.find(Member.class, memberId);
    }
}
