package com.example.demo.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OrderDto {
    private Long id;
    private Long productId;
    private LocalDate orderDate;
    private int totalAmount;
    private int orderCount;
    private String orderDetail;
}