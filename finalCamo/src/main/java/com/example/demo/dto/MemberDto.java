package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemberDto {
    private int userNumber;
    private String userId;
    private String userName;
    private String nickName;
    private String password;
    private String email;
    private Long userAddr;
    private int userPhoneNm;
    private Long userImg;
    private String userGrade;
    private int userScore;
    private String reqAgreed;
    private String optAgreed;
    private String snsLogin;
    private LocalDateTime join_time;
}
