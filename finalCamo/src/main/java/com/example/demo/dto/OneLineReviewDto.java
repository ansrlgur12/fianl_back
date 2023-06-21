
package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OneLineReviewDto {
    private Long id;
    private Long productId;
    private Long memberId;
    private Long campId;
    private String comment;
    private int rating;
}