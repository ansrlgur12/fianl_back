package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDto {
    private Long id;
    private Long productId;
    private Long memberId;
    private int productQuantity;
}
