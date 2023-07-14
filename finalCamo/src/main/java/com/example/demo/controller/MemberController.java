package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.dto.MemberResponseDto;
import com.example.demo.entity.Member;
import com.example.demo.security.SecurityUtil;
import com.example.demo.service.EmailService;
import com.example.demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
@RequestMapping("/api/v1")
public class MemberController {

    private final MemberService memberService;
    private final EmailService emailService;

    @Autowired
    public MemberController(MemberService memberService, EmailService emailService) {
        this.memberService = memberService;
        this.emailService = emailService;
    }

    /**
     *  email전송 이메일중복여부체크, 중복안되면 새로 생성해서이메일전송
     */
    @PostMapping("/intro/email")
    @ResponseBody
    public Object findEmailOverlap(@RequestBody Map<String, String> findEmailOver) throws Exception {
        String email = findEmailOver.get("emailOverlap");
        boolean isOverlap = emailService.emailOverlap(email);
        if (isOverlap) {
            return false;
        } else {
            String code = emailService.sendSimpleMessage(email);
            log.info("인증 코드: " + code);
            return code;
        }
    }

    /**
     *  사용자 ID를 이용해서 중복여부 체크
     */
    @GetMapping("/intro/nickName")
    public ResponseEntity<Boolean> overlapNick(@RequestParam String nickName){
        boolean isOverlap = memberService.nickOverlap(nickName);
        return new ResponseEntity<>(isOverlap, HttpStatus.OK);
    }

    /**
     *  사용자 ID를 이용해서 회원 정보를 조회
     */
    @GetMapping("/intro/me")
    public ResponseEntity<MemberResponseDto> findMemberById(){
        return ResponseEntity.ok(memberService.findMemberInfoById(SecurityUtil.getCurrentMemberId()));
    }


//    @PostMapping("/intro/signup")
//    public ResponseEntity<Boolean> registerMember(@RequestBody Map<String, String> data) {
//        String nickName = data.get("nickName");
//        String email = data.get("email");
//        String password = data.get("password");
//        String agreed = data.get("agreed");
//        boolean isTrue = memberService.regMember(nickName, email, password, agreed);
//        return new ResponseEntity<>(isTrue, HttpStatus.OK);
//    }

//    @PostMapping("/intro/login")
//    public ResponseEntity<Member> login(@RequestBody MemberDto memberDto) {
//        Optional<Member> member = memberService.login(memberDto.getEmail(), memberDto.getPassword());
//        if (member.isPresent()) {
//            return new ResponseEntity<>(member.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        }
//    }

//    @PostMapping("/NewPassword")
//    @ResponseBody
//    public ResponseEntity<Boolean> newPwd(@RequestBody Map<String, String> resetPwdData) {
//        String email = resetPwdData.get("email");
//        String newPwd = resetPwdData.get("newPwd");
//        return ResponseEntity.ok(memberService.changePwd(email, newPwd));
//    }

//    @PostMapping("/intro/findpwd")
//    public ResponseEntity<Boolean> memberFindPwd(@RequestBody Map<String, String> findPwdData) {
//        String nickName = findPwdData.get("nickName");
//        String email = findPwdData.get("email");
//        return ResponseEntity.ok(memberService.findPwd(nickName, email));
//    }



//    @PostMapping("/UserEdit")
//    @ResponseBody
//    public ResponseEntity<Boolean> newProfile(@RequestBody Map<String, String> newData){
//        Long id = Long.valueOf(newData.get("id"));
//        String newNick = newData.get("newNick");
//        String email = newData.get("email");
//        String userPhoneNm = newData.get("newPhone");
//        String userImg = newData.get("newImg");
//        return ResponseEntity.ok(memberService.newProfile(id, newNick, email, userPhoneNm, userImg));
//    }


}
