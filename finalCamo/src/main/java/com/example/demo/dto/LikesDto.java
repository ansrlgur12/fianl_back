package com.example.demo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class LikesDto {
    private Long count;
    private Long productId;
    private Long memberId;
    private Long campId;
}
