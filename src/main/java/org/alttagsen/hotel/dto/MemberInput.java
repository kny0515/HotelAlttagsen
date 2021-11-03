package org.alttagsen.hotel.dto;


import lombok.*;

import java.time.LocalDateTime;

@ToString
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberInput {

    private String userId;
    private String userPw;
    private String userName;
    private String userBir;
    private String userTel;
    private String userGender;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

}
