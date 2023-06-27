package com.example.demo.service;

import com.example.demo.dto.ReviewDto;
import com.example.demo.entity.Member1;
import com.example.demo.entity.Review;
import com.example.demo.repository.Member1Repository;
import com.example.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final Member1Repository member1Repository;

@Autowired
    public ReviewService(ReviewRepository reviewRepository,
                         Member1Repository member1Repository){
    this.reviewRepository = reviewRepository;
    this.member1Repository = member1Repository;
}

    /**
     * 리뷰 작성
     */
    public ReviewDto createReview(Long memberId, String title, String content, LocalDate date, int postType) {
        Member1 member = member1Repository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("회원이 없습니다."));

        Review review = new Review();
        review.setMember1(member);
        review.setTitle(title);
        review.setContent(content);
        review.setDate(date);
        review.setPostType(postType);

        Review savedReview = reviewRepository.save(review);

        return ReviewDto.builder()
                .id(savedReview.getId())
                .memberId(savedReview.getMember1().getId())
                .title(savedReview.getTitle())
                .content(savedReview.getContent())
                .date(savedReview.getDate())
                .postType(savedReview.getPostType())
                .build();
    }

    /**
     * 리뷰 수정
     */
    @Transactional
    public ReviewDto updateReview(Long id, ReviewDto reviewDto) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("회원이 없습니다."));
        review.setTitle(reviewDto.getTitle());
        review.setContent(reviewDto.getContent());
        review.setDate(reviewDto.getDate());
        review.setPostType(reviewDto.getPostType());
        Review updatedReview = reviewRepository.save(review);
        return ReviewDto.builder()
                .id(updatedReview.getId())
                .memberId(updatedReview.getMember1().getId())
                .title(updatedReview.getTitle())
                .content(updatedReview.getContent())
                .date(updatedReview.getDate())
                .postType(updatedReview.getPostType())
                .build();
    }

    /**
     * 리뷰삭제
     */
    @Transactional
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    /**
     * 특정 회원이 작성한 리뷰 가져오기
     */
    @Transactional(readOnly = true)
    public List<ReviewDto> getReviewsByMember(Long memberId) {
        List<Review> reviews = reviewRepository.findByMember1_Id(memberId);
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        for (Review review : reviews) {
            ReviewDto reviewDto = ReviewDto.builder()
                    .id(review.getId())
                    .memberId(review.getMember1().getId())
                    .title(review.getTitle())
                    .content(review.getContent())
                    .date(review.getDate())
                    .postType(review.getPostType())
                    .build();
            reviewDtoList.add(reviewDto);
        }
        return reviewDtoList;
    }

    /**
     * 특정 게시글에 맞는 글 가져오기
     */
    @Transactional(readOnly = true)
    public List<ReviewDto> getReviewsByPostType(int postType) {
        List<Review> reviews = reviewRepository.findByPostType(postType);
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        for (Review review : reviews) {
            ReviewDto reviewDto = ReviewDto.builder()
                    .id(review.getId())
                    .memberId(review.getMember1().getId())
                    .title(review.getTitle())
                    .content(review.getContent())
                    .date(review.getDate())
                    .postType(review.getPostType())
                    .build();
            reviewDtoList.add(reviewDto);
        }
        return reviewDtoList;
    }

    /**
     * 특정 게시글번호에 맞는 글 가져오기
     */
    @Transactional(readOnly = true)
    public ReviewDto getReviewById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        return ReviewDto.builder()
                .id(review.getId())
                .memberId(review.getMember1().getId())
                .title(review.getTitle())
                .content(review.getContent())
                .date(review.getDate())
                .postType(review.getPostType())
                .build();
    }

    }

