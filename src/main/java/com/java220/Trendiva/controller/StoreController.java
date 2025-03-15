package com.java220.Trendiva.controller;

import com.java220.Trendiva.dto.request.StoreSaveRequestDto;
import com.java220.Trendiva.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("store")
@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping("save")
    public void save(@RequestBody StoreSaveRequestDto dto){
        storeService.save(dto);
    }

}
