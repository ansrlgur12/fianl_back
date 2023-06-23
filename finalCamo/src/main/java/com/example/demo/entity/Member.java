package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter @Setter @ToString
public class Member {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userNumber;

    @Column(unique = true)
    private String userId;

    private String userName;

    @Column(unique = true, nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    private Long userAddr;

    private int userPhoneNm;

    private Long userImg;

    private String userGrade;

    private int userScore;

    @Column(nullable = false)
    private String reqAgreed;

    private String optAgreed;

    private String snsLogin;
}
