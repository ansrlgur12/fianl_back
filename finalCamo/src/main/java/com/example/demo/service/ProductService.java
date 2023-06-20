package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public  Product save(ProductDto productDto){// ProductDto를 매개변수로 받는 save 메소드
        Product product = new Product(); // 객체 생성
        product.setProductName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        product.setBrand(productDto.getBrand());
        product.setImageUrl(productDto.getImageUrl());
        product.setCategory3Name(productDto.getCategory3Name());
        product.setCategory4Name(productDto.getCategory4Name());
        return productRepository.save(product); 
    }
}
