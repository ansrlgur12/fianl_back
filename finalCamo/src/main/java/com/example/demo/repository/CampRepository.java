package com.example.demo.repository;

import com.example.demo.entity.Camp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampRepository extends JpaRepository<Camp, Long> {
    List<Camp> findByMapXAndMapY(String mapX, String mapY);

    List<Camp> findByAnimalCmgClNot(String animalCmgCl);

    List<Camp> findByFacltNmContaining(String facltNm);

    List<Camp> findByAnimalCmgClNotContainingAndFacltNmContaining(String animalCmgCl, String facltNm);

    List<Camp> findByDoNmContainingAndSigunguNmContaining(String doNm, String sigunguNm);

    List<Camp> findByDoNmContaining(String doNm);

    List<Camp> findByDoNmContainingAndSigunguNmContainingAndAnimalCmgClNotContaining(String doNm, String sigunguNm, String animalCmgCl);

    List<Camp> findByDoNmContainingAndAnimalCmgClNotContaining(String doNm, String animalCmgCl);
}
