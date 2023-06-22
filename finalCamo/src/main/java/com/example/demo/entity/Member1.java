package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * 임시로 만들었습니다.
 */

@Entity
@Getter
@Setter
@ToString
@Table(name = "member1")
public class Member1 {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 회원 번호

    @Column(nullable = false)
    private String username; // 회원 이름

    @Column(nullable = false)
    private String email; // 이메일

    @OneToMany(mappedBy = "member1")
    private List<Cart> cart; // 회원의 장바구니 리스트

    @OneToMany(mappedBy = "member1")
    private List<Comment> comment; // 회원의 댓글 리스트

    @ManyToOne
    @JoinColumn(name = "member1")
    private Member1 member1;

    @OneToMany(mappedBy = "member1")
    private List<OneLineReview> oneLineReviews; // 회원의 한줄평 리스트

    @OneToMany(mappedBy = "member1")
    private List<Review> review; // 회원의 리뷰 리스트
}