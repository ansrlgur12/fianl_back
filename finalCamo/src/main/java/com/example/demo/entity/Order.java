//package com.example.demo.entity;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//
///**
// * 주문
// */
//@Entity
//@Getter
//@Setter
//@ToString
//@Table(name = "orders")
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;  // 주문번호
//
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product;  // 상품번호
//
//    @Column(nullable = false)
//    private LocalDate orderDate;  // 주문일
//
//    @Column(nullable = false)
//    private int totalAmount;  // 결재금액
//
//    @Column(nullable = false)
//    private int orderCount;  // 주문갯수
//
//    private String orderDetail;  // 주문상세
//}
