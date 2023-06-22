package com.example.demo.repository;

import com.example.demo.entity.Member1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Member1Repository extends JpaRepository<Member1, Long> {
}
