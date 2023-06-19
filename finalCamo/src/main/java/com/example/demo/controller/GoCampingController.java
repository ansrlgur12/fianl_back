package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class GoCampingController {
    @GetMapping("/camping-data")
    public String getCampingData() {
        String url = "http://apis.data.go.kr/B551011/GoCamping/basedList?serviceKey=q%2FN6THt6wGszjSEFU5zzQVQIq44LTMRAzwL8RLnLtj7YRmwQec87Tx1SMf48wKbaOH2LLcoHyXVnR8YTfHapdg%3D%3D&numOfRows=3507&MobileOS=ETC&MobileApp=AppTest";

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        return response;
    }

}
