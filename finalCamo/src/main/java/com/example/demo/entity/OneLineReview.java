package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

/**
 * 한줄평
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "onelinereview")
public class OneLineReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 한줄평 번호

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "campsite_id")
    private Campsite campsite;

    @Column(nullable = false)
    private String comment; // 한줄평

    @Column(nullable = false)
    private int rating; // 한줄평 점수
}
