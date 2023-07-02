package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Camp {
    @Id
    @Column(name = "gocamping_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String facltNm;
    private String brazierCl;
    private String sbrsCl;
    private String sbrsEtc;
    private String hvofBgnde;
    private String hvofEnddle;
    private String wtrplCo;
    private String toiletCo;
    private String swrmCo;
    private String doNm;
    private String sigunguNm;
    private String zipcode;
    private String addr1;
    private String addr2;
    private String mapX;
    private String mapY;
    private String tel;
    private String homepage;
    private String resveCl;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String intro; // 소개

    @Column(length = 2000)
    private String featureNm; // 특징

    private String siteBottomCl1;
    private String siteBottomCl2;
    private String siteBottomCl3;
    private String siteBottomCl4;
    private String siteBottomCl5;
    private String extshrCo;
    private String frprvtSandCo;
    private String frprvtWrppCo;
    private String animalCmgCl;
    private String firstImageUrl;
    private String createdtime;
    private String lineIntro;
    private String eqpmnLendCl;

    @OneToMany(mappedBy = "camp")
    private List<Likes> likes; // 회원의 장바구니 리스트

    @OneToMany(mappedBy = "camp")
    private List<OneLineReview> oneLineReview; // 한줄평

    @Column
    private int viewCount = 0; // 조회수
}
