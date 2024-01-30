package NellDora.jpa_and_security.api.boardApi;

import NellDora.jpa_and_security.api.domain.Board;
import NellDora.jpa_and_security.api.dto.BoardDTO;
import NellDora.jpa_and_security.api.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BoardApiController {

    //테스트는 PostMan으로
    private final BoardService boardService;

    //소문자 사용 , _ 대신 - , 명사를 사용 /
    // C : POST , R : GET , U. PUT(전체) & PATCH(일부) , D : DELETE

    // 기본적인 REST 4가지
    @PostMapping("/boards")
    public String createBoardResponse(@RequestBody BoardDTO boardDTO){
        log.info("BoardDTO 값 : {},{},{}",boardDTO.getTitle(),boardDTO.getContent(),boardDTO.getWriter());
        Board board = Board.createBoard(boardDTO.getTitle(), boardDTO.getContent(), boardDTO.getWriter());
        boardService.save(board);
        Board findBoard = boardService.findByTitle(board.getTitle());
        return findBoard.getContent();
    }

    @GetMapping("/boards/{boardNo}")
    public Board searchBoardResponse(@PathVariable("boardNo") int boardNo){
        Board findBoard = boardService.findById(boardNo);
        return findBoard;
    }

    @PatchMapping("/boards/{boardNo}")
    public Board searchBoardResponse(@PathVariable("boardNo") int boardNo, @RequestBody BoardDTO boardDTO){

        boardService.updateBoard(boardNo, boardDTO.getTitle(),boardDTO.getContent());
        Board findBoard = boardService.findById(boardNo);
        return findBoard;
    }

    @DeleteMapping("/boards/{boardNo}")
    public String deleteBoardResponse(@PathVariable("boardNo") int boardNo){
        return boardService.deleteBoard(boardNo);
    }

    @GetMapping("/boards")
    public List<BoardDTO> searchBoards(){
        List<Board> board = boardService.findAll();
        List<BoardDTO> bdto = board.stream().map(o-> new BoardDTO(o)).collect(Collectors.toList());
        return bdto;
    }

    /*
    생각해볼 것
    다른 웹에서 API 주소로 접속했을 때에는 굉장히 취약한 구조임

     */
}
