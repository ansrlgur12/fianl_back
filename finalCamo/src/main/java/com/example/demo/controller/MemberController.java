package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("intro")
public class MemberController {
    // Service 로직 연결
    private MemberService memberService;
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String getHello() {
        return "Hello, Spring bott !!";
    }

    @GetMapping("/variable1/{variable}") // 매개 변수를 전달 받을 때 사용 함
    public String getVariable(@PathVariable String variable) {
        return variable;
    }

    @GetMapping(value = "request1") // user, name, email을 전달 받아서 리턴 함
    public String gerRequestParam(@RequestParam String user,
                                  @RequestParam String name,
                                  @RequestParam String email){
        return user + " " + name + " " + email;
    }

    @GetMapping("/members") // member 리스트 조회
    public List<Map<String, Object>> memberList() {
        List<Map<String, Object>> members = new ArrayList<>();
        for(int i = 0 ; i <= 20; i++) { // 원래 여기서 만들지 않음 테스트용
            Map<String, Object> member = new HashMap<>();
            member.put("id", i);
            member.put("name", i + "번 개발자");
            member.put("age", 10 + i);
            members.add(member);

        }
        return members;
    }

    //회원 가입
    @PostMapping("intro")
//    @RequestMapping(value = "", method = RequestMethod.POST)
    public boolean memberReg(@RequestBody Map<String, String> data){
        String nickName = data.get("nickName"); // 전송하는 키 값을 맞춰야함
        String email = data.get("email");
        String password = data.get("password");
        String agreed = data.get("agreed");
        boolean isTrue = memberService.member
        return new ResponseEntity<>(isTrue, HttpStatus.OK);
    }

    // 멤버 리스트 엔티티 타입(객체)로 리턴
    @GetMapping("/members2")
    public ResponseEntity<List<MemberDto>> memberList2(){
        List<MemberDto> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            MemberDto dto = new MemberDto();
            dto.setNickName("곰돌이" + i);
            dto.setEmail("jis@naver.com" + i);
            dto.setPassword("jis223" + i);
            dto.setUserName("곰돌이" + i);
            list.add(dto);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    /*


    //회원 가입
    @PostMapping("/reg-member")
    public ResponseEntity<Map<String, String>> memberRegister(@RequestBody Map<String, String> regData) {
        String getUserId = regData.get("user");
        String getPwd = regData.get("pwd");
        String getName = regData.get("name");
        String getMail = regData.get("mail");
        boolean result = memberService.regMember(getUserId, getPwd, getName, getMail);
        if(result) {
            return new ResponseEntity(true, HttpStatus.OK);
        } else {
            return new ResponseEntity(false, HttpStatus.BAD_REQUEST);
        }
    }

    // POST : 회원 가입

    @PostMapping("/RegMember")
    public Map<String, String> memberRegister(@RequestBody Map<String, String> regData) {
        String getNickName = regData.get("nickName");
        String getMail = regData.get("email");
        String getPwd = regData.get("userPwd");
        String getAgreed = regData.get("reqAgreed");
        MemberDto dto = new MemberDto();
        boolean isTrue = dto.memberRegister(getNickName, getMail, getPwd, getAgreed);
        Map<String, String> map = new HashMap<>();
        if(isTrue) map.put("result", "OK");
        else map.put("result", "NOK");
        return map;
    }
*/
}
