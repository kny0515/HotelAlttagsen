package org.alttagsen.hotel.service;

import org.alttagsen.hotel.dto.MemberInput;
import org.alttagsen.hotel.entity.Member;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface MemberService extends UserDetailsService {

    boolean register(MemberInput parameter);


    List<MemberInput> getMemberList();


    MemberInput getMember(String id);
}
