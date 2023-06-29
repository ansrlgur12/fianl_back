//package com.example.demo.service;
//
//import com.example.demo.dto.CartDto;
//import com.example.demo.dto.CartItemDto;
//import com.example.demo.entity.Cart;
//import com.example.demo.entity.CartItem;
//import com.example.demo.entity.Member;
//import com.example.demo.entity.Product;
//import com.example.demo.repository.CartItemRepository;
//import com.example.demo.repository.CartRepository;
//import com.example.demo.repository.MemberRepository;
//import com.example.demo.repository.ProductRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityNotFoundException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//
//@Service
//@RequiredArgsConstructor
//@Transactional
//public class CartService {
//
//    private final ProductRepository productRepository;
//    private final MemberRepository memberRepository;
//    private final CartRepository cartRepository;
//    private final CartItemRepository cartItemRepository;
//
//    // 장바구니에 상품을 추가하는 메소드
//    public Long addCart(CartItemDto cartItemDto, String email) {
//// 요청받은 상품 ID로 상품을 조회하고, 없다면 EntityNotFoundException 발생
//        Product product = productRepository.findById(cartItemDto.getProductId())
//                .orElseThrow(EntityNotFoundException::new);
//        Optional<Member> member = memberRepository.findByEmail(email);
//        // 사용자의 장바구니를 조회하고, 없다면 새로 생성 후 저장
//        Cart cart = cartRepository.findByMemberId(member.getId());
//        if (cart == null) {
//            cart = Cart.createCart(member);
//            cartRepository.save(cart);
//        }
//// 장바구니에 이미 상품이 있다면 수량을 추가, 없다면 새로운 CartItem을 생성하고 저장
//        CartItem savedCartItem = cartItemRepository.findByCartIdAndItemId(cart.getId(), product.getId());
//
//        if (savedCartItem != null) {
//            savedCartItem.addQuantity(cartItemDto.getQuantity());
//            return savedCartItem.getId();
//        } else {
//            CartItem cartItem = CartItem.createCartItem(cart, product, cartItemDto.getQuantity());
//            cartItemRepository.save(cartItem);
//            return cartItem.getId();
//        }
//    }
//    // 사용자의 장바구니 목록을 조회하는 메소드
//    @Transactional(readOnly = true)
//    public List<CartDto> getCartList(String email) {
//        List<CartDto> cartDetailDtoList = new ArrayList<CartDto>();
//
//        Optional<Member> member = memberRepository.findByEmail(email);
//        Cart cart = cartRepository.findByMemberId(member.getId());
//        if (cart == null) {
//            return cartDetailDtoList;
//        }
//      // 장바구니에 들어있는 상품들을 조회하고, DTO로 변환하여 반환
//        cartDetailDtoList = cartItemRepository.findCartDtoList(cart.getId());
//        return cartDetailDtoList;
//    }
//}