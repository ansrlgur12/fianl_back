package com.example.demo.service;

import com.example.demo.entity.Likes;
import com.example.demo.entity.Member1;
import com.example.demo.entity.Product;
import com.example.demo.repository.LikesRepository;
import com.example.demo.repository.Member1Repository;
import com.example.demo.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesService {
    private final LikesRepository likesRepository;
    private final Member1Repository member1Repository;
    private final ProductRepository productRepository;

    Logger logger = LoggerFactory.getLogger(LikesService.class); // Logger 인스턴스 생성

    @Autowired
    public LikesService(LikesRepository likesRepository, Member1Repository member1Repository, ProductRepository productRepository) {
        this.likesRepository = likesRepository;
        this.member1Repository = member1Repository;
        this.productRepository = productRepository;
    }

    public Likes likeProductByMember(Long member1Id, Long productId) {
        Member1 member = member1Repository.findById(member1Id)
                .orElseThrow(() -> {
                    logger.error("유효하지 않은 회원 ID: " + member1Id);  // 콘솔에 에러 메시지 출력
                    return new IllegalArgumentException("유효하지 않은 회원 ID: " + member1Id);
                });
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> {
                    logger.error("유효하지 않은 상품 ID: " + productId); // 콘솔에 에러 메시지 출력
                    return new IllegalArgumentException("유효하지 않은 상품 ID: " + productId);
                });

        Likes likes = new Likes();
        likes.setMember1(member);
        likes.setProduct(product);

        return likesRepository.save(likes);  // 좋아요 저장
    }
}









////package com.example.demo.service;
////
////import com.example.demo.entity.Likes;
////import com.example.demo.repository.LikesRepository;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////
////import java.util.List;
////
////@Service
////public class LikesService {
////    private final LikesRepository likesRepository;
////
////    @Autowired
////    public LikesService(LikesRepository likesRepository) {
////        this.likesRepository = likesRepository;
////    }
////
////    public int getLikeCount(Long productId) { //좋아요 갯수카운트
////        return likesRepository.count
////    }
////
////    public List<Likes> getUserLikeHistory(Long memberId) { //좋아요 기록확인
////        return likesRepository.findByMember1Id(memberId);
////    }
////}
