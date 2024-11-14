package com.example.board.service;

import com.example.board.dto.MemberResponseDto;
import com.example.board.dto.SignUpResponseDto;
import com.example.board.entity.Member;
import com.example.board.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;



    public SignUpResponseDto signUp(String username, String password, String email) {

        Member member = new Member(username,password,email);

        Member savedMember = memberRepository.save(member);

        return new SignUpResponseDto(savedMember.getId(),savedMember.getUsername(),savedMember.getEmail());
    }

    public MemberResponseDto findById(Long id) {
        Optional<Member> optinalMember = memberRepository.findById(id);
        if(optinalMember.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Does not exists id : "+ id);
        }

        Member findmember = optinalMember.get();
        return new MemberResponseDto(findmember.getUsername(), findmember.getEmail());
    }

    @Transactional
    public void updatePassword(Long id, String oldPassword, String newPassword) {

       Member findMember =  memberRepository.findByIdOrElseThrow(id);

       if(! findMember.getPassword().equals(oldPassword)){
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"비밀번호 불일치");
       }

       findMember.updatePassword(newPassword);
    }
}