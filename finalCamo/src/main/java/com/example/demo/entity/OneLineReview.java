package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

/**
 * 한줄평
 */
@Entity
@Getter
@Setter
@Table(name = "one_line_review")
public class OneLineReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 한줄평 번호

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member1 member;

    @ManyToOne
    @JoinColumn(name = "gocamping_id")
    private Camp camp;

    @Column(nullable = false)
    private String comment; // 한줄평

    @Column(nullable = false)
    private int rating; // 한줄평 점수
}
