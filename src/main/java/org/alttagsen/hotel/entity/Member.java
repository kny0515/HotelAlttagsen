package org.alttagsen.hotel.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Member extends BaseEntity{ // 회원
    @Id
    private String userId;

    private String userPw;
    private String userName;
    private String userBir;
    private String userTel;
    private String userGender;


    private boolean adminYn;
}
