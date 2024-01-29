package NellDora.jpa_and_security.api.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "board")
@Getter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardNo;
    private String title;
    private String content;
    private String writer;

    private Board(){

    }

    public static Board createBoard(String title, String content, String writer){
        Board board = new Board();
        board.title = title;
        board.content = content;
        board.writer = writer;
        return board;
    }

    public void updateBoard(String title, String content){
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardNo=" + boardNo +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
}
