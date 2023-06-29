package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CartDto {
    private Long cartItemId;
    private String productName;
    private int quantity;
    private String imageUrl;
}
