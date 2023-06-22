package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CommentDto {
    private Long id;
    private int postType;
    private Long reviewId;
    private Long memberId;
    private String content;
    private LocalDateTime createdAt;
}