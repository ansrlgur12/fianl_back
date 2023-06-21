package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class CommentDto {
    private Long id;
    private int postType;
    private Long reviewId;
    private Long memberId;
    private String content;
    private LocalDateTime createdAt;
}