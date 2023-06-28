package com.example.demo.service;

import com.example.demo.dto.ReviewDto;
import com.example.demo.entity.Member;
import com.example.demo.entity.Review;
import com.example.demo.repository.MemberRepository;
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
    private final MemberRepository memberRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, MemberRepository memberRepository) {
        this.reviewRepository = reviewRepository;
        this.memberRepository = memberRepository;
    }

    /**
     * 리뷰 작성
     */
    public ReviewDto createReview(Long memberId, String title, String content, LocalDate date, int postType) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("회원이 없습니다."));

        Review review = new Review();
        review.setMember(member);
        review.setTitle(title);
        review.setContent(content);
        review.setDate(date);
        review.setPostType(postType);

        Review savedReview = reviewRepository.save(review);

        return ReviewDto.builder()
                .id(savedReview.getId())
                .memberId(savedReview.getMember().getUserNumber())
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
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        review.setTitle(reviewDto.getTitle());
        review.setContent(reviewDto.getContent());
        review.setDate(reviewDto.getDate());
        review.setPostType(reviewDto.getPostType());
        Review updatedReview = reviewRepository.save(review);
        return ReviewDto.builder()
                .id(updatedReview.getId())
                .memberId(updatedReview.getMember().getUserNumber())
                .title(updatedReview.getTitle())
                .content(updatedReview.getContent())
                .date(updatedReview.getDate())
                .postType(updatedReview.getPostType())
                .build();
    }

    /**
     * 리뷰 삭제
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
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("회원이 없습니다."));

        List<Review> reviews = reviewRepository.findByMember(member);
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        for (Review review : reviews) {
            ReviewDto reviewDto = ReviewDto.builder()
                    .id(review.getId())
                    .memberId(review.getMember().getUserNumber())
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
     * 특정 게시글에 맞는 리뷰 가져오기
     */
    @Transactional
    public List<ReviewDto> getReviewsByPostType(int postType) {
        List<Review> reviews = reviewRepository.findByPostType(postType);
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        for (Review review : reviews) {
            ReviewDto reviewDto = ReviewDto.builder()
                    .id(review.getId())
                    .memberId(review.getMember().getUserNumber())
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
     * 특정 게시글번호에 해당하는 리뷰 가져오기
     */
    @Transactional(readOnly = true)
    public ReviewDto getReviewById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        return ReviewDto.builder()
                .id(review.getId())
                .memberId(review.getMember().getUserNumber())
                .title(review.getTitle())
                .content(review.getContent())
                .date(review.getDate())
                .postType(review.getPostType())
                .build();
    }


}
