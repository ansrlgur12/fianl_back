package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 좋아요
 */
@Entity
@Getter
@Builder
@Setter
@Table(name = "likes")
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long count; //좋아요 갯수

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