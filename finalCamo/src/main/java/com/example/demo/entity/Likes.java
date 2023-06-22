package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 좋아요
 */
@Entity
@Getter
@Setter
@Table(name = "likes")
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //좋아요 번호

    @ManyToOne
    @JoinColumn(name = "product")
    private Product product; // 상품번호

    @ManyToOne
    @JoinColumn(name = "member1")
    private Member1 member1; // !! 회원번호

    @ManyToOne
    @JoinColumn(name = "camp")
    private Camp camp; //

    @Column(nullable = false)
    private int likes; // 좋아요

    @Column(nullable = false)
    private LocalDateTime createdAt;
}