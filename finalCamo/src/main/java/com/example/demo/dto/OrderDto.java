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
public class OrderDto {
    private Long id;
    private Long productId;
    private LocalDate orderDate;
    private int totalAmount;
    private int orderCount;
    private String orderDetail;
}