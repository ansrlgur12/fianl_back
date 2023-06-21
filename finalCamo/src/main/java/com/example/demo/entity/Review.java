package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.time.LocalDate;

/**
 * 리뷰
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "review")
public class Review {
    @Id
    @Column(name="product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false) //게시글 제목
    private String title;

    @Column(nullable = false) //게시글 내용
    private String content;

    @Column(nullable = false) //작성일자
    private LocalDate date;

    @Column(nullable = false) //글타입
    private int postType;
}
