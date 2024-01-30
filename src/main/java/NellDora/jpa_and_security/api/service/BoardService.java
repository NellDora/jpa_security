package NellDora.jpa_and_security.api.service;

import NellDora.jpa_and_security.api.domain.Board;
import NellDora.jpa_and_security.api.repository.BoardRepository;
import NellDora.jpa_and_security.api.repository.JpaBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Board findById(int id){
        return boardRepository.findById(id);
    }

    public void updateBoard(int id,String title, String content){
        Board findBoard =boardRepository.findById(id);
        findBoard.updateBoard(title, content);
    }

    public String deleteBoard(int id){
        return boardRepository.delete(id);
    }

    public List<Board> findAll(){
        return boardRepository.findAll();
    }
}
