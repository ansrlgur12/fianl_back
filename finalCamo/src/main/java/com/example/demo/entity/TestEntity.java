package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class TestEntity {
    @Id
    @Column(name = "test_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Test;
}