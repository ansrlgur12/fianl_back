package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("intro")
public class MemberController {

    /**
     * Service 로직 연결
     */
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 회원 가입
     */

//    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @PostMapping("/signup")
    public ResponseEntity<Boolean> registerMember(@RequestBody Map<String, String> data) {
        System.out.println("넘어온 데이터 : " + data);
        String nickName = data.get("nickName"); // 전송하는 키 값을 맞춰야함
        String email = data.get("email");
        String password = data.get("password");
        String agreed = data.get("agreed");
        boolean isTrue = memberService.regMember(nickName, email, password, agreed);
        return new ResponseEntity<>(isTrue, HttpStatus.OK);
    }

    /**
     * 로그인
     */
//    @PostMapping("/login")
//    public ResponseEntity<Member> login(@RequestBody MemberDto memberDto) {
//        Optional<Member> member = memberService.login(memberDto.getEmail(), memberDto.getPassword());
//        if (member.isPresent()) {
//            // 로그인 성공
//            return new ResponseEntity<>(member.get(), HttpStatus.OK);
//        } else {
//            // 로그인 실패
//            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        }
//    }
    // POST : 로그인 체크
    @PostMapping(value="/login")
    public ResponseEntity<Boolean> login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");
        System.out.println("이메일 : " + email);
        System.out.println("패스워드 : " + password);
        boolean result = memberService.login(email, password);
        if (result) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
}