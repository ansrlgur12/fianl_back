package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class LikesDto {
    private Long id;
    private Long productId;
    private Long memberId;
    private Long campId;
    private int likes;
    private LocalDateTime createdAt;
}
