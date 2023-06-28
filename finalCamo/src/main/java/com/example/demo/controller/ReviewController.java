package com.example.demo.controller;

import com.example.demo.dto.ReviewDto;
import com.example.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    /**
     * 리뷰 작성
     */
    @PostMapping
    public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewDto reviewDto) {
        ReviewDto createdReview = reviewService.createReview(
                reviewDto.getMemberId(),
                reviewDto.getTitle(),
                reviewDto.getContent(),
                reviewDto.getDate(),
                reviewDto.getPostType()
        );

        return ResponseEntity.ok(createdReview);
    }

    /**
     * 리뷰 수정
     */
    @PutMapping("/{id}")
    public ResponseEntity<ReviewDto> updateReview(@PathVariable("id") Long id, @RequestBody ReviewDto reviewDto) {
        ReviewDto updatedReview = reviewService.updateReview(id, reviewDto);
        return ResponseEntity.ok(updatedReview);
    }

    /**
     * 리뷰삭제
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable("id") Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * 특정 회원이 작성한 리뷰 가져오기
     */
    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<ReviewDto>> getReviewsByMember(@PathVariable("memberId") Long memberId) {
        List<ReviewDto> reviews = reviewService.getReviewsByMember(memberId);
        return ResponseEntity.ok(reviews);
    }

    /**
     * 특정 게시글에 맞는 글 가져오기
     */
    @GetMapping("/postType/{postType}")
    public ResponseEntity<List<ReviewDto>> getReviewsByPostType(@PathVariable("postType") int postType) {
        List<ReviewDto> reviews = reviewService.getReviewsByPostType(postType);
        return ResponseEntity.ok(reviews);
    }

    /**
     * 특정 게시글번호에 맞는 글 가져오기
     */
    @GetMapping("/reviewById/{id}")
    public ResponseEntity<ReviewDto> getReviewById(@PathVariable("id") Long id) {
        ReviewDto review = reviewService.getReviewById(id);
        return ResponseEntity.ok(review);
    }

}
