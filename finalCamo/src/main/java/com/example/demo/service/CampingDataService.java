package com.example.demo.service;


import com.example.demo.dto.CampDto;
import com.example.demo.entity.Camp;
import com.example.demo.repository.CampRepository;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CampingDataService {
    @Autowired
    private CampRepository campRepository;
    private CampDto campDto;




    public void fetchAndSaveCampingData() {
        String url = "http://apis.data.go.kr/B551011/GoCamping/basedList?serviceKey=q%2FN6THt6wGszjSEFU5zzQVQIq44LTMRAzwL8RLnLtj7YRmwQec87Tx1SMf48wKbaOH2LLcoHyXVnR8YTfHapdg%3D%3D&numOfRows=3507&MobileOS=ETC&MobileApp=AppTest";

        // Create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Send GET request and retrieve the response
        String response = restTemplate.getForObject(url, String.class);

        // Parse the response and save it to the database
        CampDto campDto = parseResponse(response);
        Camp campingDataEntity = convertToEntity(campDto);
        campRepository.save(campingDataEntity);
    }

    private CampDto parseResponse(String response) {
        // 공공 API 응답 데이터를 파싱하여 CampingDataDTO 객체로 변환하는 로직을 구현해야 합니다.
        // 실제로는 응답 데이터에 맞게 적절한 파싱 로직을 작성해야 합니다.
        return new CampDto();
    }

    private Camp convertToEntity(CampDto campingDataDTO) {
        // CampingDataDTO 객체를 CampingDataEntity 객체로 변환하는 로직을 구현해야 합니다.
        // 실제로는 필드 값을 복사하거나 매핑하는 작업을 수행해야 합니다.
        return new Camp();
    }

    public Camp save(CampDto campDto){// ProductDto를 매개변수로 받는 save 메소드
        Camp camp = new Camp(); // 객체 생성
        camp.setFacltNm(campDto.getFacltNm());
        camp.setBrazierCl(campDto.getBrazierCl());
        camp.setSbrsCl(campDto.getSbrsCl());
        camp.setSbrsEtc(campDto.getSbrsEtc());
        camp.setHvofBgnde(campDto.getHvofBgnde());
        camp.setHvofEnddle(campDto.getHvofEnddle());
        camp.setWtrplCo(campDto.getWtrplCo());
        camp.setToiletCo(campDto.getToiletCo());
        camp.setSwrmCo(campDto.getSwrmCo());
        camp.setDoNm(campDto.getDoNm());
        camp.setSigunguNm(campDto.getSigunguNm());
        camp.setZipcode(campDto.getZipcode());
        camp.setAddr1(campDto.getAddr1());
        camp.setAddr2(campDto.getAddr2());
        camp.setMapX(campDto.getMapX());
        camp.setMapY(campDto.getMapY());
        camp.setTel(campDto.getTel());
        camp.setHomepage(campDto.getHomepage());
        camp.setResveCl(campDto.getResveCl());
        camp.setFeatureNm(campDto.getFeatureNm());
        camp.setIntro(campDto.getIntro());
        camp.setSiteBottomCl1(campDto.getSiteBottomCl1());
        camp.setSiteBottomCl2(campDto.getSiteBottomCl2());
        camp.setSiteBottomCl3(campDto.getSiteBottomCl3());
        camp.setSiteBottomCl4(campDto.getSiteBottomCl4());
        camp.setSiteBottomCl5(campDto.getSiteBottomCl5());
        camp.setExtshrCo(campDto.getExtshrCo());
        camp.setFrprvtSandCo(campDto.getFrprvtSandCo());
        camp.setFrprvtWrppCo(campDto.getFrprvtWrppCo());
        camp.setAnimalCmgCl(campDto.getAnimalCmgCl());
        camp.setFirstImageUrl(campDto.getFirstImageUrl());
        camp.setCreatedtime(campDto.getCreatedtime());
        camp.setLineIntro(campDto.getLineIntro());
        camp.setEqpmnLendCl(campDto.getEqpmnLendCl());
        return campRepository.save(camp);
    }
    //    public void saveCampingData(List<CampDto> campDto) {
//        List<Camp> campingEntityList = new ArrayList<>();
//        for (CampDto campingDTO : campDto) {
//            Camp camp = new Camp();
//            camp.setFacltNm(campingDTO.getFacltNm());
//
//            campingEntityList.add(camp);
//        }
//        campRepository.saveAll(campingEntityList);
//    }
    public void saveCampingData(JsonNode arrayNode) {
        List<CampDto> campingDTOList = new ArrayList<>();
        for (JsonNode item : arrayNode) {
            CampDto campingDTO = new CampDto();
            campingDTO.setFacltNm(item.get("facltNm").asText());
            campingDTO.setBrazierCl(item.get("brazierCl").asText());
            campingDTO.setSbrsCl(item.get("sbrsCl").asText());
            campingDTO.setSbrsEtc(item.get("sbrsEtc").asText());
            campingDTO.setHvofBgnde(item.get("hvofBgnde").asText());
            campingDTO.setHvofEnddle(item.get("hvofEnddle").asText());
            campingDTO.setWtrplCo(item.get("wtrplCo").asText());
            campingDTO.setToiletCo(item.get("toiletCo").asText());
            campingDTO.setSwrmCo(item.get("swrmCo").asText());
            campingDTO.setDoNm(item.get("doNm").asText());
            campingDTO.setSigunguNm(item.get("sigunguNm").asText());
            campingDTO.setZipcode(item.get("zipcode").asText());
            campingDTO.setAddr1(item.get("addr1").asText());
            campingDTO.setAddr2(item.get("addr2").asText());
            campingDTO.setMapX(item.get("mapX").asText());
            campingDTO.setMapY(item.get("mapY").asText());
            campingDTO.setTel(item.get("tel").asText());
            campingDTO.setHomepage(item.get("homepage").asText());
            campingDTO.setResveCl(item.get("resveCl").asText());
            campingDTO.setIntro(item.get("intro").asText());
            campingDTO.setFeatureNm(item.get("featureNm").asText());
            campingDTO.setSiteBottomCl1(item.get("siteBottomCl1").asText());
            campingDTO.setSiteBottomCl2(item.get("siteBottomCl2").asText());
            campingDTO.setSiteBottomCl3(item.get("siteBottomCl3").asText());
            campingDTO.setSiteBottomCl4(item.get("siteBottomCl4").asText());
            campingDTO.setSiteBottomCl5(item.get("siteBottomCl5").asText());
            campingDTO.setExtshrCo(item.get("extshrCo").asText());
            campingDTO.setFrprvtSandCo(item.get("frprvtSandCo").asText());
            campingDTO.setFrprvtWrppCo(item.get("frprvtWrppCo").asText());
            campingDTO.setAnimalCmgCl(item.get("animalCmgCl").asText());
            campingDTO.setFirstImageUrl(item.get("firstImageUrl").asText());
            campingDTO.setCreatedtime(item.get("createdtime").asText());
            campingDTO.setLineIntro(item.get("lineIntro").asText());
            campingDTO.setEqpmnLendCl(item.get("eqpmnLendCl").asText());

            campingDTOList.add(campingDTO);
        }
        for (CampDto campingDTO : campingDTOList) {
            save(campingDTO);
        }
    }

    public List<CampDto> getCampData(){
        List<Camp> items = campRepository.findAll();
        List<CampDto> campDtos = new ArrayList<>();
        for (Camp camp : items) {
            CampDto campDto = new CampDto();
            campDto.setFacltNm(camp.getFacltNm());
            campDto.setBrazierCl(camp.getBrazierCl());
            campDto.setSbrsCl(camp.getSbrsCl());
            campDto.setSbrsEtc(camp.getSbrsEtc());
            campDto.setHvofBgnde(camp.getHvofBgnde());
            campDto.setHvofEnddle(camp.getHvofEnddle());
            campDto.setWtrplCo(camp.getWtrplCo());
            campDto.setToiletCo(camp.getToiletCo());
            campDto.setSwrmCo(camp.getSwrmCo());
            campDto.setDoNm(camp.getDoNm());
            campDto.setSigunguNm(camp.getSigunguNm());
            campDto.setZipcode(camp.getZipcode());
            campDto.setAddr1(camp.getAddr1());
            campDto.setAddr2(camp.getAddr2());
            campDto.setMapX(camp.getMapX());
            campDto.setMapY(camp.getMapY());
            campDto.setTel(camp.getTel());
            campDto.setHomepage(camp.getHomepage());
            campDto.setResveCl(camp.getResveCl());
            campDto.setIntro(camp.getIntro());
            campDto.setFeatureNm(camp.getFeatureNm());
            campDto.setSiteBottomCl1(camp.getSiteBottomCl1());
            campDto.setSiteBottomCl2(camp.getSiteBottomCl2());
            campDto.setSiteBottomCl3(camp.getSiteBottomCl3());
            campDto.setSiteBottomCl4(camp.getSiteBottomCl4());
            campDto.setSiteBottomCl5(camp.getSiteBottomCl5());
            campDto.setExtshrCo(camp.getExtshrCo());
            campDto.setFrprvtSandCo(camp.getFrprvtSandCo());
            campDto.setFrprvtWrppCo(camp.getFrprvtWrppCo());
            campDto.setAnimalCmgCl(camp.getAnimalCmgCl());
            campDto.setFirstImageUrl(camp.getFirstImageUrl());
            campDto.setCreatedtime(camp.getCreatedtime());
            campDto.setLineIntro(camp.getLineIntro());
            campDto.setEqpmnLendCl(camp.getEqpmnLendCl());
            campDtos.add(campDto);
        }
        return campDtos;
    }

    public List<CampDto> getOverlay(String xValue, String yValue){
        List<Camp> items = campRepository.findByMapXAndMapY(xValue, yValue);
        List<CampDto> campDtos = new ArrayList<>();
        for (Camp camp : items ) {
            CampDto campDto = new CampDto();
            campDto.setFacltNm(camp.getFacltNm());
            campDto.setAddr1(camp.getAddr1());
            campDto.setTel(camp.getTel());
            campDto.setFirstImageUrl(camp.getFirstImageUrl());
            campDtos.add(campDto);
        }
        return campDtos;
    }

}