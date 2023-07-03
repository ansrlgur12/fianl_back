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
@RequestMapping("")
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

    @RequestMapping(value = "/intro/signup", method = RequestMethod.POST)
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
     * 로그인(JSON)
     */
    @PostMapping("/intro/login")
    public ResponseEntity<Member> login(@RequestBody MemberDto memberDto) {
        Optional<Member> member = memberService.login(memberDto.getEmail(), memberDto.getPassword());
        if (member.isPresent()) {
            // 로그인 성공
            return new ResponseEntity<>(member.get(), HttpStatus.OK);
        } else {
            // 로그인 실패
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    /**
     * 로그인(Boolean)
     */
//    @PostMapping(value="/intro/login")
//    public ResponseEntity<Boolean> login(@RequestBody Map<String, String> loginData) {
//        String email = loginData.get("email");
//        String password = loginData.get("password");
//        System.out.println("이메일 : " + email);
//        System.out.println("패스워드 : " + password);
//        boolean result = memberService.login(email, password);
//        if (result) {
//            return new ResponseEntity<>(true, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
//        }
//    }
    /**
     * 비밀번호 변경
     */
    @PostMapping("/intro/newpwd")
    @ResponseBody
    public ResponseEntity<Boolean> newPwd(@RequestBody Map<String, String> resetPwdData) {
        String email = resetPwdData.get("email");
        String newPwd = resetPwdData.get("newPwd");
        return ResponseEntity.ok(memberService.changePwd(email, newPwd));
    }

    /**
     * 비밀 번호 찾기
     */
    @PostMapping("/intro/findpwd")
    public ResponseEntity<Boolean> memberFindPwd(@RequestBody Map<String, String> findPwdData) {
        String nickName = findPwdData.get("nickName");
        String email = findPwdData.get("email");
        return ResponseEntity.ok(memberService.findPwd(nickName, email));
    }

    /**
     * 닉네임 중복 확인
     */
    @GetMapping("/intro")
    public ResponseEntity<Boolean> overlapNick(@RequestParam String nickName){
        boolean isOverlap = memberService.nickOverlap(nickName);
        return new ResponseEntity<>(isOverlap, HttpStatus.OK);
    }

    /**
     * 프로필 수정
     */
    @PostMapping("/intro/changeprofile")
    @ResponseBody
    public ResponseEntity<Boolean> newProfile(@RequestBody Map<String, String> newData){
        Long id = Long.valueOf(newData.get("id"));
        String email = newData.get("email");
        String newNick = newData.get("newNick");
        String userPhoneNm = newData.get("newPhone");
        String userImg = newData.get("newImg");
        return ResponseEntity.ok(memberService.newProfile(id, email, newNick, userPhoneNm, userImg));
    }

    /**
     * 회원 탈퇴
     */


    /**
     * 계정 찾기
     */


}