package com.example.demo.repository;

import com.example.demo.entity.Camp;
import com.example.demo.entity.Likes;
import com.example.demo.entity.Member1;
import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {
    int countByProduct(Product product);
    void deleteByMember1AndProduct(Member1 member1, Product product);

    int countByCamp(Camp camp);
    void deleteByMember1AndCamp(Member1 member1, Camp camp);
}