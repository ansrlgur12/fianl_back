package com.example.demo.repository;

import com.example.demo.entity.Camp;
import com.example.demo.entity.Likes;
import com.example.demo.entity.Member;
import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {
    int countByProduct(Product product);
    void deleteByMemberAndProduct(Member member, Product product);

    int countByCamp(Camp camp);
    void deleteByMemberAndCamp(Member member, Camp camp);
}