package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 댓글
 */
@Entity
@Getter
@Setter
@ToString
@Table(name="comment")

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //댓글 번호

    private int postType; // 글타입

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false)
    private String content; //댓글 내용

    @Column(nullable = false)
    private LocalDateTime createdAt; //작성일자
}