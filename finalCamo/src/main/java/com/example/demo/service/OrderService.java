package com.example.demo.service;

import com.example.demo.dto.OrderDto;
import com.example.demo.dto.OrderHistDto;
import com.example.demo.dto.OrderItemDto;
import com.example.demo.entity.Member;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.entity.Product;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {


    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;


    public Long order(OrderDto orderDto, String email) {
        Product product = productRepository.findById(orderDto.getItemId())
                .orElseThrow(EntityNotFoundException::new);
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(EntityNotFoundException::new);

        List<OrderItem> orderItemList = new ArrayList<>();
        OrderItem orderItem = OrderItem.createOrderItem(product, orderDto.getCount());
        orderItemList.add(orderItem);

        Order order = Order.createOrder(member, orderItemList);
        orderRepository.save(order);

        return order.getId();
    }

    @Transactional(readOnly = true)
    public Page<OrderHistDto> getOrderList(String email, Pageable pageable) {

        List<Order> orders = orderRepository.findOrders(email, pageable);   // 사용자 이메일과 페이징 정보를 기반으로 주문 목록을 조회

        Long totalCount = orderRepository.countOrder(email);   // 사용자 이메일을 기반으로 총 주문 수를 계산

        List<OrderHistDto> orderHistDtos = new ArrayList<>(); // 주문 목록을 담을 orderHistDtos 리스트를 생성

        for (Order order : orders) {   // 주문 목록을 담을 orderHistDtos 리스트를 생성

            OrderHistDto orderHistDto = new OrderHistDto(order);   // 주문의 정보를 담은 OrderHistDto 객체를 생성

            List<OrderItem> orderItems = order.getOrderItems();  // 주문 항목들을 가져옴

            for (OrderItem orderItem : orderItems) { // 각 주문 항목에 대해 반복문을 실행

                String imageUrl = orderItem.getProduct().getImageUrl(); // 해당 주문 항목의 상품 이미지를 조회

                OrderItemDto orderItemDto = new OrderItemDto(orderItem, imageUrl);   // 주문 항목 정보와 이미지 URL을 포함한 OrderItemDto 객체를 생성

                orderHistDto.addOrderItemDto(orderItemDto);     // orderHistDto에 OrderItemDto 객체를 추가
            }

            orderHistDtos.add(orderHistDto);  // 최종적으로 생성된 orderHistDto를 orderHistDtos 리스트에 추가
        }

        return new PageImpl<OrderHistDto>(orderHistDtos, pageable, totalCount);  // 페이징 정보와 함께 주문 내역 리스트를 반환
    }

    @Transactional(readOnly = true)
    public boolean validateOrder(Long orderId, String email){
        Member curMember = memberRepository.findByEmail(email)
                .orElseThrow(EntityNotFoundException::new);

        Order order = orderRepository.findById(orderId)
                .orElseThrow(EntityNotFoundException::new);
        Member savedMember = order.getMember();

        if(!StringUtils.equals(curMember.getEmail(), savedMember.getEmail())){
            return false;
        }

        return true;
    }

    public void cancelOrder(Long orderId){
        Order order = orderRepository.findById(orderId)
                .orElseThrow(EntityNotFoundException::new);
        order.cancelOrder();
    }

    public Long orders(List<OrderDto> orderDtoList, String email){

        Member member = memberRepository.findByEmail(email)
                .orElseThrow(EntityNotFoundException::new);
        List<OrderItem> orderItemList = new ArrayList<>();

        for (OrderDto orderDto : orderDtoList) {
            Product product = productRepository.findById(orderDto.getItemId())
                    .orElseThrow(EntityNotFoundException::new);

            OrderItem orderItem = OrderItem.createOrderItem(product, orderDto.getCount());
            orderItemList.add(orderItem);
        }

        Order order = Order.createOrder(member, orderItemList);
        orderRepository.save(order);

        return order.getId();
    }
}
