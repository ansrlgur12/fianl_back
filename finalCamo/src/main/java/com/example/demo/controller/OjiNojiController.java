package com.example.demo.controller;

import com.example.demo.dto.OjiNojiDto;
import com.example.demo.repository.OjiNojiRepository;
import com.example.demo.service.OjiNojiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/oji")
public class OjiNojiController {

    private final OjiNojiService ojiNojiService;
    private final OjiNojiRepository ojiNojiRepository;


    @PostMapping("/newMark")
    public ResponseEntity<Boolean> newMark(@RequestBody Map<String, String> data) {
        Boolean isTrue = ojiNojiService.save(data);
        return new ResponseEntity<>(isTrue, HttpStatus.OK);
    }
}
