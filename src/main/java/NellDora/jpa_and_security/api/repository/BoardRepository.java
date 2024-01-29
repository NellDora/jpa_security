package NellDora.jpa_and_security.api.repository;

import NellDora.jpa_and_security.api.domain.Board;

public interface BoardRepository {

    public void save(Board board);

    public Board findByTitle(String title);

    public Board findById(int id);

    public String delete(int id);
}
