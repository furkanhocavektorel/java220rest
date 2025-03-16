package com.java220.Trendiva.controller;

import com.java220.Trendiva.dto.request.ProductSaveRequestDto;
import com.java220.Trendiva.dto.response.ProductResponseDto;
import com.java220.Trendiva.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("product")
@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @PostMapping("save")
    public void save(@RequestBody ProductSaveRequestDto dto){
        productService.save(dto);
    }

    // get all products
    @GetMapping("get-all")
    public List<ProductResponseDto> findAll(){
        return productService.findAll();
    }



}
