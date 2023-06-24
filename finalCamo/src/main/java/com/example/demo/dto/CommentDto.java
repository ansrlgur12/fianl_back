package com.example.demo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CommentDto {
    private Long id;
    private int postType;
    private Long reviewId;
    private Long memberId;
    private String content;
    private LocalDateTime createdAt;
}