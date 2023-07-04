package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class OjiNoji {
    @Id
    @Column(name = "oji_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String facltNm;
    private String doNm;
    private String sigunguNm;
    private String mapX;
    private String mapY;
    private String intro;
    private String sbrsCl;
    private String diff;
}
