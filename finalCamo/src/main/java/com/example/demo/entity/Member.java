package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Getter @Setter @ToString
public class Member {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userNumber;

    private String userName;

    @Column(unique = true, nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String password;

    @Id
    @Column(unique = true, nullable = false)
    private Long email;

    private String userAddr;

    private int userPhoneNm;

    private String userImg;

    private String userGrade;

    private int userScore;

    @Column(nullable = false)
    private String reqAgreed;

    private String optAgreed;

    private String snsLogin;

    private LocalDateTime join_time;
}
