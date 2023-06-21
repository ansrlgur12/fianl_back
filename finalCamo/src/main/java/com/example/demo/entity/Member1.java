//package com.example.demo.entity;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//import javax.persistence.*;
//import java.util.List;
//
///**
// * 임시로 만들었습니다.
// */
//
//@Entity
//@Getter
//@Setter
//@ToString
//@Table(name = "member1")
//public class Member1 {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id; // 회원 번호
//
//    @Column(nullable = false)
//    private String username; // 회원 이름
//
//    @Column(nullable = false)
//    private String email; // 이메일
//
//    @OneToMany(mappedBy = "member1")
//    private List<Cart> carts; // 회원의 장바구니 리스트
//
//    @OneToMany(mappedBy = "member1")
//    private List<Comment> comments; // 회원의 댓글 리스트
//
//    @OneToMany(mappedBy = "member1")
//    private List<Likes> likes; // 회원의 좋아요 리스트
//
//    @OneToMany(mappedBy = "member1")
//    private List<OneLineReview> oneLineReviews; // 회원의 한줄평 리스트
//
//    @OneToMany(mappedBy = "member1")
//    private List<Order> orders; // 회원의 주문 리스트
//
//    @OneToMany(mappedBy = "member1")
//    private List<Review> reviews; // 회원의 리뷰 리스트
//}
