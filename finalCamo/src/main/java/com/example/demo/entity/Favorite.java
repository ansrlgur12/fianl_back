package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 찜목록
 */
@Entity
@Getter
@Setter
@Table(name= "favorite")
public class Favorite {


    @Id
    @Column(name="favorite_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //찜목록 번호

    @ManyToOne
    @JoinColumn(name = "member")
    private Member member;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    }

