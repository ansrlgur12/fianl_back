package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

/**
 * 주문
 */
@Entity
@Getter
@Setter
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 주문번호

    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;  // 상품번호

    @ManyToOne
    @JoinColumn(name = "member")
    private Member member;  // 상품번호

    @Column(nullable = false)
    private LocalDate orderDate;  // 주문일

    @Column(nullable = false)
    private int totalAmount;  // 결재금액

    @Column(nullable = false)
    private int orderCount;  // 주문갯수

    private String orderDetail;  // 주문상세
}