//package com.example.demo.entity;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
///**
// * 좋아요
// */
//@Entity
//@Getter
//@Setter
//@ToString
//@Table(name = "likes") // 'Like'는 SQL 키워드이므로 likes로
//public class Likes {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id; //좋아요 번호
//
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product; // 상품번호
//
//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private Member member; // !! 회원번호
//
//    @ManyToOne
//    @JoinColumn(name = "campsite_id")
//    private Campsite campsite; // !! 캠핑장번호
//
//    @Column(nullable = false)
//    private int likes; // 좋아요
//
//    @Column(nullable = false)
//    private LocalDateTime createdAt; //작성일자
//}
