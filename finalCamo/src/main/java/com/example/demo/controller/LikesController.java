package com.example.demo.controller;

import com.example.demo.dto.LikesDto;
import com.example.demo.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/likes")
public class LikesController {
    private final LikesService likesService;

    @Autowired
    public LikesController(LikesService likesService) {
        this.likesService = likesService;
    }

    @PostMapping("/{member1Id}/{productId}") //특정회원 특정상품 좋아요 갯수 추가
    public LikesDto likeProductByMember(@PathVariable Long member1Id, @PathVariable Long productId) {
        return likesService.likeProductByMember(member1Id, productId);
    }

    @DeleteMapping("/{member1Id}/{productId}") //특정 제품 좋아요 취소
    public void unlikeProductByMember(@PathVariable Long member1Id, @PathVariable Long productId) {
        likesService.unlikeProductByMember(member1Id, productId);
    }

//    @GetMapping("/{member1Id}/{productId}")
//    public boolean isProductLikedByMember(@PathVariable Long member1Id, @PathVariable Long productId) {
//        return likesService.isProductLikedByMember(member1Id, productId);
//    }

    @GetMapping("/count/{productId}") //특정 제품 좋아요 갯수 조회
    public int countLikesByProduct(@PathVariable Long productId) {
        return likesService.countLikesByProduct(productId);
    }
}
