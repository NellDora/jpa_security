package NellDora.jpa_and_security.api.service;

import NellDora.jpa_and_security.api.domain.Board;
import NellDora.jpa_and_security.api.repository.BoardRepository;
import NellDora.jpa_and_security.api.repository.JpaBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void save (Board board){
        boardRepository.save(board);
    }

    public Board findByTitle(String title){
        return boardRepository.findByTitle(title);
    }
}
