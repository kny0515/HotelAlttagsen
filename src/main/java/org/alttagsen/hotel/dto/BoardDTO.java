package org.alttagsen.hotel.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private Long bno;
    private String title;
    private String content;
    private String writerUserId; // 작성자의 이메일(id)
    private String writerUserName; // 작성자의 이름
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private int replyCount; // 해당 게시글의 댓글 수
}
