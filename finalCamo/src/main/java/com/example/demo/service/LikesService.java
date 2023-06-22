package com.example.demo.service;

import com.example.demo.entity.Likes;
import com.example.demo.repository.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikesService {
    private final LikesRepository likesRepository;

    @Autowired
    public LikesService(LikesRepository likesRepository) {
        this.likesRepository = likesRepository;
    }

//    public int getLikeCount(Long productId) { //좋아요 갯수카운트
//        return likesRepository.countByProduct_Id(productId);
//    }
//
//    public boolean hasUserLiked(Long memberId, Long productId) { 좋아요 여부 확인
//        return likesRepository.existsByMember_IdAndProduct_Id(memberId, productId);
//    }
//
//    public List<Likes> getUserLikeHistory(Long memberId) { 좋아요 기록 확인
//        return likesRepository.findByMember_Id(memberId);
//    }
}
