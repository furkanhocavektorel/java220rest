package com.java220.Trendiva.controller;

import com.java220.Trendiva.dto.request.ProductSaveRequestDto;
import com.java220.Trendiva.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("product")
@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @PostMapping("save")
    public void save(@RequestBody ProductSaveRequestDto dto){

        productService.save(dto);
    }


}
