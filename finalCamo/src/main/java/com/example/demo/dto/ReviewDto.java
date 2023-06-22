package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ReviewDto {
    private Long id;
    private Long memberId;
    private String title;
    private String content;
    private LocalDate date;
    private int postType;
}
