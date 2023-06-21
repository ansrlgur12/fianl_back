package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

/**
 * 장바구니
 */
@Entity
@Getter
@Setter
@Table(name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //장바구니 번호

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName="id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName="id")
    private Member1 member;

    @Column(nullable = false)
    private int productQuantity; // 상품 수량
}