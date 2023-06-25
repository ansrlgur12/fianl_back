package com.example.demo.entity;


import lombok.*;
import javax.persistence.*;

/**
 * 좋아요
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "likes")
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long count;

    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "member1")
    private Member1 member1;

    @ManyToOne
    @JoinColumn(name = "camp")
    private Camp camp;

}