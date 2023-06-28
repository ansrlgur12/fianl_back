package com.example.demo.service;

import com.example.demo.dto.LikesDto;
import com.example.demo.entity.Camp;
import com.example.demo.entity.Likes;
import com.example.demo.entity.Member;
import com.example.demo.entity.Product;
import com.example.demo.repository.CampRepository;
import com.example.demo.repository.LikesRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LikesService {

    private final LikesRepository likesRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final CampRepository campRepository;

    @Autowired
    public LikesService(LikesRepository likesRepository, MemberRepository memberRepository,
                        ProductRepository productRepository, CampRepository campRepository) {
        this.likesRepository = likesRepository;
        this.memberRepository = memberRepository;
        this.productRepository = productRepository;
        this.campRepository = campRepository;
    }

    /**
     * 특정 상품 좋아요
     */
    public LikesDto likeProductByMember(Long memberId, Long productId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("회원이 없습니다."));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("제품이 없습니다."));

        Likes savedLike = Likes.builder()
                .member(member)
                .product(product)
                .build();
        savedLike = likesRepository.save(savedLike);

        LikesDto likesDto = LikesDto.builder()
                .count(savedLike.getCount())
                .productId(savedLike.getProduct().getId())
                .memberId(savedLike.getMember().getUserNumber())
                .build();

        return likesDto;
    }

    /**
     * 특정 상품 좋아요 취소
     */
    public void unlikeProductByMember(Long memberId, Long productId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("회원이 없습니다."));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("제품이 없습니다."));
        likesRepository.deleteByMemberAndProduct(member, product);
    }

    /**
     * 특정 상품 좋아요 갯수 확인
     */
    public int countLikesByProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("제품이 없습니다."));
        return likesRepository.countByProduct(product);
    }

    /**
     * 특정 캠핑장 좋아요
     */
    public LikesDto likeCampByMember(Long memberId, Long campId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("회원이 없습니다."));
        Camp camp = campRepository.findById(campId)
                .orElseThrow(() -> new RuntimeException("캠핑장이 없습니다."));

        Likes savedLike = Likes.builder()
                .member(member)
                .camp(camp)
                .build();
        savedLike = likesRepository.save(savedLike);

        LikesDto likesDto = LikesDto.builder()
                .count(savedLike.getCount())
                .campId(savedLike.getCamp().getId())
                .memberId(savedLike.getMember().getUserNumber())
                .build();

        return likesDto;
    }


    /**
     * 특정 캠핑장 좋아요 취소
     */
    public void unlikeCampByMember(Long memberId, Long campId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("회원이 없습니다."));
        Camp camp = campRepository.findById(campId)
                .orElseThrow(() -> new RuntimeException("캠프가 없습니다."));
        likesRepository.deleteByMemberAndCamp(member, camp);
    }

    /**
     * 특정 캠핑장 좋아요 갯수 확인
     */
    public int countLikesByCamp(Long campId) {
        Camp camp = campRepository.findById(campId)
                .orElseThrow(() -> new RuntimeException("캠프가 없습니다."));
        return likesRepository.countByCamp(camp);
    }
}
