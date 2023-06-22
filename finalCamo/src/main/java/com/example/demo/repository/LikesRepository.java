package com.example.demo.repository;

import com.example.demo.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {
    void deleteById(Long id); // 좋아요 삭제

    Likes save(Likes like); // 좋아요 삽입

    List<Likes> findByMember1(Long memberId); // 특정 사용자의 좋아요 조회
}