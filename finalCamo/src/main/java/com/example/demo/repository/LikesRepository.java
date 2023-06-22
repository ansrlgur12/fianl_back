package com.example.demo.repository;

import com.example.demo.entity.Likes;
import com.example.demo.entity.Member1;
import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {
    Likes findByMember1AndProduct(Member1 member1, Product product); //특정 회원 좋아요 조회
    int countByProduct(Product product); //좋아요 갯수 증가
    void deleteByMember1AndProduct(Member1 member1, Product product); //좋아요 삭제
}
