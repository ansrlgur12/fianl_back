package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.service.MemberService;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("intro")
public class MemberController {

    /**
     * Service 로직 연결
     */
    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 회원 가입
     */



    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Boolean> registerMember(@RequestBody Map<String, String> data) {
        System.out.println(data);
        String nickName = data.get("nickName"); // 전송하는 키 값을 맞춰야함
        String email = data.get("email");
        String password = data.get("pwd");
        String agreed = data.get("agreed");
        boolean isTrue = memberService.regMember(nickName, email, password, agreed);
        return new ResponseEntity<>(isTrue, HttpStatus.OK);
    }

    /**
     * 로그인
     *
    @PostMapping("")
    public ResponseEntity<Boolean> login(@RequestBody Map<String, String> data) {
        String email = data.get("email");
        String password = data.get("pwd");

        boolean loginResult = memberService.login(email, password);
        if (loginResult) {
            // 로그인 성공
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            // 로그인 실패
            return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
        }
*/

    @GetMapping("")
    public ResponseEntity<Boolean> login(
            @RequestParam("email") String email,
            @RequestParam("pwd") String password
    ) {
        boolean loginResult = memberService.login(email, password);
        if (loginResult) {
            // 로그인 성공
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            // 로그인 실패
            return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
        }
    }
}
