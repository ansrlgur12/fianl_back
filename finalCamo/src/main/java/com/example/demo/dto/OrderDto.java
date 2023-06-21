package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class OrderDto {
    private Long id;
    private Long productId;
    private LocalDate orderDate;
    private int totalAmount;
    private int orderCount;
    private String orderDetail;
}