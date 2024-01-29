package NellDora.jpa_and_security.api.repository;

import NellDora.jpa_and_security.api.domain.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
        String jpql = "select b from Board b where b.title = :title";
        TypedQuery<Board> query = em.createQuery(jpql, Board.class);
        query.setParameter("title",title);
        return query.getSingleResult();
    }

    @Override
    public Board findById(int id) {
        return em.find(Board.class, id);
    }

    @Override
    public String delete(int id) {
        String jpql = "delete from Board b where b.boardNo = :id";
        em.createQuery(jpql).setParameter("id", id).executeUpdate();
        return "success";
    }

}
