//package com.example.demo.service;
//
//import com.example.demo.entity.CartItem;
//import com.example.demo.entity.Product;
//import com.example.demo.repository.CartItemRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class CartItemService {
//
//    private final CartItemRepository cartItemRepository;
//
//
//    public CartItem createCartItem(Product product, int quantity) {
//        CartItem cartItem = new CartItem();
//        cartItem.setProduct(product);
//        cartItem.setQuantity(quantity);
//        return cartItemRepository.save(cartItem);
//    }
//}
