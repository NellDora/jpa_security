package NellDora.jpa_and_security.api.dto;

import NellDora.jpa_and_security.api.domain.Board;
import lombok.Data;

@Data
public class BoardDTO {
    private int boardNo;
    private String title;
    private String content;
    private String writer;

    public BoardDTO(Board board){
        boardNo = board.getBoardNo();
        title = board.getTitle();
        content = board.getContent();
        writer = board.getWriter();
    }

}
