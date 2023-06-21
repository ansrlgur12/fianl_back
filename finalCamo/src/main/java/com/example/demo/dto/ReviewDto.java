package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class ReviewDto {
    private Long id;
    private Long memberId;
    private String title;
    private String content;
    private LocalDate date;
    private int postType;
}
