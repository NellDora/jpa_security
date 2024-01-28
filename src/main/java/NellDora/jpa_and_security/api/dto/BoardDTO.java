package NellDora.jpa_and_security.api.dto;

import lombok.Data;

@Data
public class BoardDTO {
    private int boardNo;
    private String title;
    private String content;
    private String writer;

}
