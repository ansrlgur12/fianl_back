package com.example.demo.service;

import com.example.demo.dto.LikesDto;
import com.example.demo.entity.Likes;
import com.example.demo.entity.Member1;
import com.example.demo.entity.Product;
import com.example.demo.repository.LikesRepository;
import com.example.demo.repository.Member1Repository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LikesService {

    private final LikesRepository likesRepository;
    private final Member1Repository member1Repository;
    private final ProductRepository productRepository;


    @Autowired
    public LikesService(LikesRepository likesRepository, Member1Repository member1Repository, ProductRepository productRepository) {
        this.likesRepository = likesRepository;
        this.member1Repository = member1Repository;
        this.productRepository = productRepository;
    }

    /**
     * 특정 상품 좋아요
     */
    public LikesDto likeProductByMember(Long member1Id, Long productId) {
        Member1 member1 = member1Repository.findById(member1Id)
                .orElseThrow(() -> new RuntimeException("회원이 없습니다.")); // 에러처리
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("제품이 없습니다."));

        Likes savedLike = Likes.builder() //빌더 에노테이션 사용해 엔티티에서 dto 변환
                .member1(member1)
                .product(product)
                .build();
        savedLike = likesRepository.save(savedLike);

        LikesDto likesDto = LikesDto.builder()
                .count(savedLike.getCount())
                .productId(savedLike.getProduct().getId())
                .memberId(savedLike.getMember1().getId())
                .build();

        return likesDto;
    }


    /**
     * 특정 상품 좋아요 취소
     */
    public void unlikeProductByMember(Long member1Id, Long productId) {
        Member1 member1 = member1Repository.findById(member1Id).orElseThrow(()-> new RuntimeException("회원이 없습니다."));
        Product product = productRepository.findById(productId).orElseThrow(()-> new RuntimeException("제품이 없습니다."));
        likesRepository.deleteByMember1AndProduct(member1, product);
    }


    /**
     * 특정 상품 좋아요 갯수확인
     */
    public int countLikesByProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(()-> new RuntimeException("제품이 없습니다."));
        return likesRepository.countByProduct(product);
    }
}


//    public boolean isProductLikedByMember(Long member1Id, Long productId) {
//        Member1 member1 = member1Repository.findById(member1Id).orElseThrow(()-> new RuntimeException("회원이 없습니다."));
//        Product product = productRepository.findById(productId).orElseThrow(()-> new RuntimeException("제품이 없습니다."));
//        Likes like = likesRepository.findByMember1AndProduct(member1, product);
//        return like != null;
//    }