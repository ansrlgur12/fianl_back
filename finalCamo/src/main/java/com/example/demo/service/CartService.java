package com.example.demo.service;

import com.example.demo.entity.Cart;
import com.example.demo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addToCart(Cart cart) { // 장바구니 상품 추가 또는 업데이트
        cartRepository.save(cart);
    }

    public void removeFromCart(Long cartId) { // 장바구니 상품 삭제
        cartRepository.deleteById(cartId);
    }

//    public List<Cart> getCartByMember(Long memberId) { // 특정 사용자 장바구니 조회
//        return cartRepository.findByMember_Id(memberId);
//    }
//
//    public void clearCartByMember(Long memberId) { // 특정 사용자의 장바구니 비우기
//        List<Cart> cartList = cartRepository.findByMember_Id(memberId);
//        cartRepository.deleteAll(cartList);
    }
