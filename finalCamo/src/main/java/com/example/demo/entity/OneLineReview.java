package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

/**
 * 한줄평
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "one_line_review")
public class OneLineReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 한줄평 번호

    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "member1")
    private Member1 member1;

    @ManyToOne
    @JoinColumn(name = "camp")
    private Camp camp;

    @Column(nullable = false)
    private String comment; // 한줄평

    @Column(nullable = false)
    private int rating; // 한줄평 점수
}