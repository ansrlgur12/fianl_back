package com.example.demo.controller;

import com.example.demo.dto.CampDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Camp;
import com.example.demo.service.CampingDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/camp")
public class GoCampingController {

    private final CampingDataService campingDataService;

    @GetMapping("/camping-data") // 캠핑장 정보 불러오기
    public String getCampingData() throws JsonProcessingException {
        String url = "http://apis.data.go.kr/B551011/GoCamping/basedList?serviceKey=q/N6THt6wGszjSEFU5zzQVQIq44LTMRAzwL8RLnLtj7YRmwQec87Tx1SMf48wKbaOH2LLcoHyXVnR8YTfHapdg==&numOfRows=3507&MobileOS=ETC&MobileApp=AppTest&_type=json";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String jsonResponse = response.getBody();

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode root = objectMapper.readTree(jsonResponse);
        JsonNode arrayNode = root.get("response").get("body").get("items").get("item");

        campingDataService.saveCampingData(arrayNode);
        return null;
    }

    @GetMapping("/campData")
    public ResponseEntity<List<CampDto>> campData() {
        List<CampDto> list = campingDataService.getCampData();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/overlay/{xValue}/{yValue}")
    public ResponseEntity<List<CampDto>> overlay(@PathVariable String xValue, @PathVariable String yValue){
        List<CampDto> list = campingDataService.getOverlay(xValue, yValue);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/animalData")
    public ResponseEntity<List<CampDto>> animalData() {
        List<CampDto> list = campingDataService.getAnimalData();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/searchData/{searchValue}/{currentData}")
    public ResponseEntity<List<CampDto>> searchData(@PathVariable String searchValue, @PathVariable String currentData){
        System.out.println(searchValue + " : searchValue 값");
        System.out.println(currentData + " : currentData 값");
        List<CampDto> list = campingDataService.getSearchData(searchValue, currentData);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}

