package com.example.demo.service;

import com.example.demo.dto.OjiNojiDto;
import com.example.demo.entity.OjiNoji;
import com.example.demo.repository.OjiNojiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OjiNojiService {
    @Autowired
    private OjiNojiRepository ojiNojiRepository;
    private OjiNojiDto ojiNojiDto;

    public Boolean save(Map<String, String> data){
        OjiNoji ojiNoji = new OjiNoji();
        System.out.println(data);
        ojiNoji.setMapX(data.get("mapX"));
        ojiNoji.setMapY(data.get("mapY"));
        ojiNoji.setSbrsCl(data.get("sbrsCl"));
        ojiNoji.setDoNm(data.get("doNm"));
        ojiNoji.setSigunguNm(data.get("sigunguNm"));
        ojiNoji.setFacltNm(data.get("facltNm"));
        ojiNoji.setDiff(data.get("diff"));
        ojiNoji.setIntro(data.get("intro"));

        ojiNojiRepository.save(ojiNoji);
        return true;
    }
}
