package com.example.demo.repository;

import com.example.demo.entity.OjiNoji;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OjiNojiRepository extends JpaRepository<OjiNoji, Long> {

}
