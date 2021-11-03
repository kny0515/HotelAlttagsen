package org.alttagsen.hotel.service.impl;

import lombok.RequiredArgsConstructor;
import org.alttagsen.hotel.dto.MemberInput;
import org.alttagsen.hotel.entity.Member;
import org.alttagsen.hotel.repository.MemberRepository;
import org.alttagsen.hotel.service.MemberService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public boolean register(MemberInput parameter) {

        Optional<Member> optionalMember = memberRepository.findById(parameter.getUserId());

        if(optionalMember.isPresent()){
            // 현재 userId에 해당하는 데이터 존재
            return false;
        }

        String encPassword = BCrypt.hashpw(parameter.getUserPw(), BCrypt.gensalt());

        Member member = Member.builder()
                    .userId(parameter.getUserId())
                    .userPw(encPassword)
                    .userName(parameter.getUserName())
                    .userBir(parameter.getUserBir())
                    .userGender(parameter.getUserGender())
                    .userTel(parameter.getUserTel())
                    .build();

        memberRepository.save(member);

        return true;
    }

    @Override
    public List<MemberInput> getMemberList() {
        List<Member> members = memberRepository.findAll();
        List<MemberInput> memberInputList = new ArrayList<>();

        for (Member member : members){
            MemberInput memberInput = MemberInput.builder()
                    .userId(member.getUserId())
                    .userPw(member.getUserPw())
                    .userName(member.getUserName())
                    .userBir(member.getUserBir())
                    .userTel(member.getUserTel())
                    .userGender(member.getUserGender())
                    .regDate(member.getRegDate())
                    .modDate(member.getModDate())
                    .build();

            memberInputList.add(memberInput);
        }
        return memberInputList;
    }

    @Override
    public MemberInput getMember(String id) {
        Optional<Member> optionalMember = memberRepository.findById(id);

        if (optionalMember.isPresent()){
            Member member = optionalMember.get();

            MemberInput memberInput = MemberInput.builder()
                    .userId(member.getUserId())
                    .userPw(member.getUserPw())
                    .userName(member.getUserName())
                    .userBir(member.getUserBir())
                    .userTel(member.getUserTel())
                    .userGender(member.getUserGender())
                    .regDate(member.getRegDate())
                    .modDate(member.getModDate())
                    .build();

            return memberInput;
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Member> optionalMember = memberRepository.findById(username);
        if (!optionalMember.isPresent()){
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다.");
        }
        Member member = optionalMember.get();

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        if(member.isAdminYn()){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        return new User(member.getUserId(), member.getUserPw(),grantedAuthorities);
    }
}
