package com.example.demo.repository;

import com.example.demo.entity.Camp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampRepository extends JpaRepository<Camp, Long> {
    List<Camp> findByMapXAndMapY(String mapX, String mapY);
}
