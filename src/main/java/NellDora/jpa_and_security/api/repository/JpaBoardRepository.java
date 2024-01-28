package NellDora.jpa_and_security.api.repository;

import NellDora.jpa_and_security.api.domain.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
@Transactional
@Slf4j
@RequiredArgsConstructor
public class JpaBoardRepository implements BoardRepository{

    private final EntityManager em;

    @Override
    public void save(Board board)
    {
        log.info("Save 호출");
        log.info("board 정보 {}", board.toString());
        em.persist(board);
    }

    @Override
    public Board findByTitle(String title) {
        String jpql = "select * from board as b where b.title = :title";
        Board board = em.createQuery(jpql, Board.class).setParameter(title,title).getSingleResult();
        return board;
    }
}
