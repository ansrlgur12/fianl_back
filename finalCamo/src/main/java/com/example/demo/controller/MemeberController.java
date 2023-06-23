package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MemeberController {
    // POST : 회원 가입
/*
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
