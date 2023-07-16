package com.example.demo.service;

import com.example.demo.dto.CampDto;
import com.example.demo.entity.Camp;
import com.example.demo.repository.CampRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@EnableScheduling
@RequiredArgsConstructor
public class CampSchedular {
    @Autowired
    private CampRepository campRepository;
    private CampDto campDto;

    @Scheduled(cron = "0 0 4 * * *") // 매일 새벽 4시에 실행
    public void updateCampingData() throws JsonProcessingException {
        // API 호출 및 응답 처리
        String url = "http://apis.data.go.kr/B551011/GoCamping/basedList?serviceKey=q/N6THt6wGszjSEFU5zzQVQIq44LTMRAzwL8RLnLtj7YRmwQec87Tx1SMf48wKbaOH2LLcoHyXVnR8YTfHapdg==&numOfRows=3507&MobileOS=ETC&MobileApp=AppTest&_type=json";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String jsonResponse = response.getBody();

        // JSON 응답 처리
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(jsonResponse);
        JsonNode arrayNode = root.get("response").get("body").get("items").get("item");

        List<CampDto> campingDTOList = new ArrayList<>();
        for (JsonNode item : arrayNode) {
            CampDto campDto = new CampDto();
            campDto.setFacltNm(item.get("facltNm").asText());
            campDto.setBrazierCl(item.get("brazierCl").asText());
            campDto.setSbrsCl(item.get("sbrsCl").asText());
            campDto.setSbrsEtc(item.get("sbrsEtc").asText());
            campDto.setWtrplCo(item.get("wtrplCo").asText());
            campDto.setToiletCo(item.get("toiletCo").asText());
            campDto.setSwrmCo(item.get("swrmCo").asText());
            campDto.setDoNm(item.get("doNm").asText());
            campDto.setSigunguNm(item.get("sigunguNm").asText());
            campDto.setAddr1(item.get("addr1").asText());
            campDto.setMapX(item.get("mapX").asText());
            campDto.setMapY(item.get("mapY").asText());
            campDto.setTel(item.get("tel").asText());
            campDto.setHomepage(item.get("homepage").asText());
            campDto.setResveCl(item.get("resveCl").asText());
            campDto.setIntro(item.get("intro").asText());
            campDto.setFeatureNm(item.get("featureNm").asText());
            campDto.setAnimalCmgCl(item.get("animalCmgCl").asText());
            campDto.setFirstImageUrl(item.get("firstImageUrl").asText());
            campDto.setCreatedtime(item.get("createdtime").asText());
            campDto.setLineIntro(item.get("lineIntro").asText());
            campDto.setEqpmnLendCl(item.get("eqpmnLendCl").asText());
            campDto.setContentId(item.get("contentId").asText());

            campingDTOList.add(campDto);
        }
        for (CampDto campingDTO : campingDTOList) {
            save(campingDTO);
        }
    }
    public Camp save(CampDto campDto){
        Camp camp = new Camp(); // 객체 생성
        camp.setFacltNm(campDto.getFacltNm());
        camp.setBrazierCl(campDto.getBrazierCl());
        camp.setSbrsCl(campDto.getSbrsCl());
        camp.setSbrsEtc(campDto.getSbrsEtc());
        camp.setWtrplCo(campDto.getWtrplCo());
        camp.setToiletCo(campDto.getToiletCo());
        camp.setSwrmCo(campDto.getSwrmCo());
        camp.setDoNm(campDto.getDoNm());
        camp.setSigunguNm(campDto.getSigunguNm());
        camp.setAddr1(campDto.getAddr1());
        camp.setMapX(campDto.getMapX());
        camp.setMapY(campDto.getMapY());
        camp.setTel(campDto.getTel());
        camp.setHomepage(campDto.getHomepage());
        camp.setResveCl(campDto.getResveCl());
        camp.setFeatureNm(campDto.getFeatureNm());
        camp.setIntro(campDto.getIntro());
        camp.setAnimalCmgCl(campDto.getAnimalCmgCl());
        camp.setFirstImageUrl(campDto.getFirstImageUrl());
        camp.setCreatedtime(campDto.getCreatedtime());
        camp.setLineIntro(campDto.getLineIntro());
        camp.setEqpmnLendCl(campDto.getEqpmnLendCl());
        camp.setContentId(campDto.getContentId());
        return campRepository.save(camp);
    }
}
