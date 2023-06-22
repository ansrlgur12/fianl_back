package com.example.demo.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * 리뷰
 */
@Entity
@Getter
@Setter
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="review")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member1")
    private Member1 member1;

    @Column(nullable = false) //게시글 제목
    private String title;

    @Column(nullable = false) //게시글 내용
    private String content;

    @Column(nullable = false) //작성일자
    private LocalDate date;

    @Column(nullable = false) //글타입
    private int postType;
}