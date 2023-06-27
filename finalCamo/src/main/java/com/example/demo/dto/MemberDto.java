package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class MemberDto {
    private Long userNumber;
    private String userId;
    private String userName;
    private String nickName;
    private String password;
    private String email;
    private String userAddr;
    private int userPhoneNm;
    private String userImg;
    private String userGrade;
    private int userScore;
    private String reqAgreed;
    private String optAgreed;
    private String snsLogin;
    private LocalDate join_time;
}
