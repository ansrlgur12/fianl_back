package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CartDto {
    private Long id;
    private Long productId;
    private Long memberId;
    private int productQuantity;
}
