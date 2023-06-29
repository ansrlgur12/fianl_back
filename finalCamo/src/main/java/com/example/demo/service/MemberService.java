package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@ToString
@Service
//@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

//    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MemberService (MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public List<Member> findMember() {
        return memberRepository.findAll();
    }

    public boolean regMember(String nickName, String email, String password, String agreed) {
        // 이메일 중복 체크
        Optional<Member> existingMember = memberRepository.findByEmail(email);
        if (existingMember.isPresent()) {
            // 이미 같은 이메일로 가입된 회원이 있는 경우
            return false;
        }

        // 회원 가입 로직을 처리하는 코드 작성
        Member newMember = new Member();
        newMember.setNickName(nickName);
        newMember.setEmail(email);
        newMember.setPassword(password);
        newMember.setReqAgreed(agreed);
        newMember.setJoin_time(LocalDateTime.now());
        newMember.setUserGrade("1");
        // 회원 저장
        memberRepository.save(newMember);

        return true;
    }

//    public Optional<Member> login(String email, String password) {
//        // 이메일과 비밀번호를 기반으로 회원을 검색
//        Optional<Member> memberOptional = memberRepository.findByEmailAndPassword(email, password);
//        if (memberOptional.isPresent()) {
//            // 회원이 존재하면 로그인 성공
//            return memberOptional;
//        } else {
//            // 회원이 존재하지 않으면 로그인 실패
//            return Optional.empty();
//        }
//    }
    // 로그인 체크
    public boolean login(String email, String password) {
        Optional<Member> memberOptional = memberRepository.findByEmailAndPassword(email, password);
        if (memberOptional.isPresent()) {
            System.out.println(memberOptional);
            return true;
        }
        return false;
    }

    /**
     * 프로필 수정, 비밀번호 변경, 회원 탈퇴
     */

}
