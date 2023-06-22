
package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OneLineReviewDto {
    private Long id;
    private Long productId;
    private Long memberId;
    private Long campId;
    private String comment;
    private int rating;
}