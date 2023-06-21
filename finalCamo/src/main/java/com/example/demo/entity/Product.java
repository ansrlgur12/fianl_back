package com.example.demo.entity;




import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString

public class Product {

    @Id
    @Column(name="product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private double price;
    private String brand;
    private String imageUrl;
    private String category3Name;
    private String category4Name;


}
