package com.example.demo.controller;

import com.example.demo.entity.Likes;
import com.example.demo.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
public class LikesController {
    private final LikesService likesService;

    @Autowired
    public LikesController(LikesService likesService) {
        this.likesService = likesService;
    }

    @PostMapping("/{member1Id}/{productId}")
    public Likes likeProductByMember(@PathVariable Long member1Id, @PathVariable Long productId) {
        return likesService.likeProductByMember(member1Id, productId);
    }
}
