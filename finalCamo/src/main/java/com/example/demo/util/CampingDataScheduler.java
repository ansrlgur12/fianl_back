package com.example.demo.util;

import com.example.demo.service.CampingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CampingDataScheduler {
    private final CampingDataService campingDataService;

    @Autowired
    public CampingDataScheduler(CampingDataService campingDataService) {
        this.campingDataService = campingDataService;
    }

    @Scheduled(cron = "0 45 10 * * ?") // 매일 자정에 실행
    public void fetchCampingData() {
        System.out.println("통신 완료 !!!!");
        // 공공 API에서 데이터를 가져오는 로직을 구현
        // 가져온 데이터를 DTO 객체로 파싱
        // DTO 객체를 엔티티 객체로 변환
        // 엔티티 객체를 데이터베이스에 저장
        campingDataService.fetchAndSaveCampingData();
    }
}