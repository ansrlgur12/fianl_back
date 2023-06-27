package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userNumber;
    private String userName;
    @Column(unique = true, nullable = false)
    private String nickName;
    @Column(nullable = false)
    private String password;
    @Column(unique = true, nullable = false)
    private String email;
    private String userAddr;
    private int userPhoneNm;
    private String userImg;
    private String userGrade = "1";
    private int userScore;
    @Column(nullable = false)
    private String reqAgreed;
    private String optAgreed;
    private String snsLogin;
    private LocalDateTime join_time;
}
