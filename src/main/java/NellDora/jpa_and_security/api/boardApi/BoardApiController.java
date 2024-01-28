package NellDora.jpa_and_security.api.boardApi;

import NellDora.jpa_and_security.api.domain.Board;
import NellDora.jpa_and_security.api.dto.BoardDTO;
import NellDora.jpa_and_security.api.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BoardApiController {

    //테스트는 PostMan으로
    private final BoardService boardService;

    //소문자 사용 , _ 대신 - , 명사를 사용 /
    // C : POST , R : GET , U. PUT(전체) & PATCH(일부) , D : DELETE
    @PostMapping("/board")
    public String createBoard(@RequestBody BoardDTO boardDTO){
        log.info("BoardDTO 값 : {},{},{}",boardDTO.getTitle(),boardDTO.getContent(),boardDTO.getWriter());
        Board board = Board.createBoard(boardDTO.getTitle(), boardDTO.getContent(), boardDTO.getWriter());
        boardService.save(board);
        Board findBoard = boardService.findByTitle(board.getTitle());
        return findBoard.getContent();
    }
}
